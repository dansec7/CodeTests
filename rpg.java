
import java.util.Scanner;
import java.io.IOException;
      
public class rpg
{
  public static void main(String[] args) throws IOException
  {
  
    String userClass = "";
    String userWeapon = "";
    
    int gold = 0;
    int goldWallet = 0;
    
    int sStr = 0;
    int sDex = 0;
    int sInt = 0;
    int sChr = 0;
    int sLck = 0;

 /*   
    int tStr = 0;
    int tDex = 0;
    int tInt = 0;
    int tChr = 0;
    int tLck = 0;
    */
    
    int path = 4; //set to zero for full game, change to jump sections
    int user_hp = 0;
    int user_dmg = 0;
    int user_dodge = 0;
    int userXP = 0;
    
    int barb_hp = 105;
    int barb_str = 12;
    int barb_dodge = 2;

    int paladin_hp = 115;
    int paladin_str = 10;
    int paladin_dodge = 1;

    int rogue_hp = 95;
    int rogue_str = 14;
    int rogue_dodge = 4;
    
    int undeadHP = 35;
    int undeadDMG = 5;
    int undeadXP = 20;
    int undeadHP_max = 0;
    
    int undeadNum = 0;
    
    int inv_max = 4;
    int inv_slot1 = 0;
    int inv_slot2 = 0;
    int inv_slot3 = 0;
    int inv_slot4 = 0;
   
    int classInput = 0;
    int statInput = 10;
    int temp_i = 0;
    int inCombat = 0;
    int user_combat_dmg = 0;
    int user_combat_dmg_float = 0;
    int enemy_combat_dmg = 0;
    int enemy_count_max = 0;
    
    
    
    System.out.println("Choose your hero:");
    System.out.println("1. Barbarian");
    System.out.println("2. Paladin");
    System.out.println("3. Rogue\n");
    Scanner sc = new Scanner(System.in);
    while (!sc.hasNextInt()) sc.next(); //this prevents crash from user inputting letters
    int userInput = sc.nextInt();
    
    do
    {   
       if (userInput == 1) //set user information
       {
         userClass = "Barbarian";
         userWeapon = "Battle Axe";
         user_hp = barb_hp;
         sStr = barb_str;
         sDex = barb_dodge;
         classInput = 1;
       }
       else if (userInput == 2)
       {
         userClass = "Paladin"; 
         userWeapon = "Long Sword";
         user_hp = paladin_hp;
         user_dmg = paladin_str;
         user_dodge = paladin_dodge;
         classInput = 2;
       }
       else if (userInput == 3)
       {
         userClass = "Rogue";
         userWeapon = "Serrated Blade";
         user_hp = rogue_hp;
         user_dmg = rogue_str;
         user_dodge = rogue_dodge;
         classInput = 3;
       }
       else
       {
         System.out.println("Enter either \"1\", \"2\", or \"3\"");
         while (!sc.hasNextInt()) sc.next();
         userInput = sc.nextInt();
       }
    } while (classInput == 0);

    System.out.println("You chose the " + userClass + "!");
    System.out.println("Equipped: " + userWeapon + "\n");
    System.out.println("Choose your main attributes:");
    System.out.println("1. Strength");
    System.out.println("2. Dexterity");
    System.out.println("3. Intelligence");
    System.out.println("4. Charisma");
    System.out.println("5. Luck");
    System.out.println("You have 10 stat points to allocate!\n");
    
    while (statInput > 0)
    { 
       Scanner scan2 = new Scanner(System.in);
       while (!scan2.hasNextInt()) scan2.next(); //this prevents crash from user inputting letters
       int statTInput = scan2.nextInt();
       if (statTInput == 1)
       {
         sStr ++;
         user_hp += ((sStr * 2));
         System.out.println(sStr + " point(s) allocated in Strength. Strength increases your physical damage and total health pool. Total health pool is now " + user_hp + ".");
         statInput -= 1;
         System.out.println("You have " + statInput + " points left!\n");
         statTInput = 0;
       }
       else if (statTInput == 2)
       {
         sDex += 1;
         user_dodge += (((sDex * 1.5) + 0.94) / ((sDex + 1) * 0.2));
         System.out.println(sDex + " point(s) allocated in Dexterity. Dexterity increases your chance to avoid attacks and overall stealth. Dodge chance is now " + user_dodge + "%.");
         statInput -= 1;
         System.out.println("You have " + statInput + " points left!\n");
         statTInput = 0;
       }
       else if (statTInput == 3)
       {
         sInt += 1;
         System.out.println(sInt + " point(s) allocated in Intelligence. Intelligence increases your magic damage and total mana pool.");
         statInput -= 1;
         System.out.println("You have " + statInput + " points left!\n");
         statTInput = 0;
       }
       else if (statTInput == 4)
       {
         sChr += 1;
         System.out.println(sChr + " total point(s) allocated in Charisma. Charisma increases your social skills considerably.");
         statInput -= 1;
         System.out.println("You have " + statInput + " points left!\n");
         statTInput = 0;
       }
       else if (statTInput == 5)
       {
         sLck += 1;
         System.out.println(sLck + " point(s) allocated in Luck. Luck increases your general fortune.");
         statInput -= 1;
         System.out.println("You have " + statInput + " points left!\n");
         statTInput = 0;
       }
       else
       {
         System.out.println("Enter either \"1\", \"2\", \"3\", \"4\", or \"5\"");
         continue;
       }  
    }
    
    user_dmg += (sStr * 3);
    System.out.print("You have entered the world of Azinoth");
    
    for (int i = 0; i < 2; i++)
    {
      System.out.print(".");
      temp_i += 1;
      try
      {
         Thread.sleep(800);
      }
      catch (InterruptedException ie)
      {
      }
      if (temp_i == 2)
      {
         System.out.print(".\n\n");
         temp_i = 0;
      }
    }
    
    System.out.println("Choose your path:");
    System.out.println("1. Head towards the abandoned city");
    System.out.println("2. Enter the nearby jungle");
    System.out.println("3. Begin making your way to the capital city Lethin\n");
    
    while (path == 0)
    {
      Scanner scan3 = new Scanner(System.in);
      while (!scan3.hasNextInt()) scan3.next(); //this prevents crash from user inputting letters
      temp_i = scan3.nextInt();        
      if (temp_i == 1)
      {
         path = 1;
         temp_i = 0;
      }
      else if (temp_i == 2)
      {
         path = 2;
         temp_i = 0;
      }
      else if (temp_i == 3)
      {
         path = 3;
         temp_i = 0;
      }
      else 
      {
         System.out.println("Enter either \"1\", \"2\", or \"3\"");
         continue;
      }
    }
    
    while (path == 1)
    {
      inCombat += 1;
      
      while (inCombat == 1)
      {
         undeadNum = getRandom(3,5);
         enemy_count_max += undeadNum;
         System.out.println("Along the road towards the abandoned city");
         System.out.println("you spot a group of " + undeadNum + " Undead ");
         for (int i = 0; i < 3; i++)
         {
            System.out.print(".");
            temp_i += 1;
            try
            {
               Thread.sleep(800);
            }
            catch (InterruptedException ie)
            {
            }
         }
         System.out.print(" and engage!\n");
         temp_i = 0;
         
         if (sStr >= 9)
         {
            try
            {
               Thread.sleep(1500);
            }
            catch (InterruptedException ie)
            {
            }
            System.out.println("[STRENGTH 9 - CHECK PASSED]");
            System.out.println("You leap into battle with rage and a mighty swing of your " + userWeapon + " obliterates 2 of the " + undeadNum + " Undead!\n");
            undeadNum -= 2;
            undeadHP_max = (undeadHP * undeadNum);
            try
            {
               Thread.sleep(1500);
            }
            catch (InterruptedException ie)
            {
            }
            for (int i = 0; i < 100; i++)
            {
               try
               {
                  Thread.sleep(1000);
               }
               catch (InterruptedException ie)
               {
               }
               System.out.println("You swing dealing " + user_dmg + " to the undead.");
               user_combat_dmg += user_dmg;
               undeadHP_max -= user_dmg;           
               if (user_combat_dmg >= undeadHP && user_combat_dmg < (undeadHP * 2))
               {
                  undeadNum -= 1;
                  user_combat_dmg_float = (user_combat_dmg - undeadHP);
                  user_combat_dmg = 0;
                  System.out.println("1 Undead perishes!");
                  try
                  {
                     Thread.sleep(1000);
                  }
                  catch (InterruptedException ie)
                  {
                  }
               }
               if (user_combat_dmg >= (undeadHP * 2) && (user_combat_dmg < (undeadHP * 3)))
               {
                  undeadNum -= 2;
                  user_combat_dmg_float = (user_combat_dmg - (undeadHP * 2));
                  user_combat_dmg = 0;
                  System.out.println("2 Undead perish!");
                  try
                  {
                     Thread.sleep(1000);
                  }
                  catch (InterruptedException ie)
                  {
                  }
               }
               if (undeadHP_max <= 0)
               {
                  undeadNum = 0;
                  System.out.println("All enemies have been vanquished!");
                  System.out.println("You gain " + (enemy_count_max * undeadXP) + " experience!\n");
                  userXP += (enemy_count_max * undeadXP);
                  inCombat = 0;
                  path = 4;
                  user_combat_dmg = 0;
                  user_combat_dmg_float = 0;
                  enemy_count_max = 0;
                  break;
               }
               undeadHP_max = (undeadHP * undeadNum);
               undeadHP_max -= user_combat_dmg_float;
               user_combat_dmg_float = 0;
               System.out.println(undeadNum + " Undead remain!\n");
               try
               {
                  Thread.sleep(1000);
               }
               catch (InterruptedException ie)
               {
               }
               if (getRandom(1,100) < user_dodge)
               {
                  System.out.println("The (" + undeadNum + ") Undead swing and you DODGE! [" + user_dodge + "%]\n");
               }
               else
               {
                  user_hp -= (undeadDMG * undeadNum);
                  System.out.println("The (" + undeadNum + ") Undead swing dealing " + (undeadDMG * undeadNum) + " to you. " + user_hp + " health left!\n");
                  if (user_hp <= 0)
                  {
                     System.out.println("The Undead swing and inflict mortal wounds. You have died.\n");
                     System.out.println("Press enter to continue...");
                     Scanner keyboard = new Scanner(System.in);
                     String s = keyboard.nextLine();
                     if (s.equals(""))
                     {
                        System.exit(0);
                     }
                  }
               }
            }
         }
         else if (sStr < 9)
         {
            undeadHP_max = (undeadHP * undeadNum);
            for (int i = 0; i < 100; i++)
            {
               try
               {
                  Thread.sleep(1000);
               }
               catch (InterruptedException ie)
               {
               }
               System.out.println("You swing dealing " + user_dmg + " to the undead.");
               user_combat_dmg += user_dmg;
               undeadHP_max -= user_dmg;  
               if (user_combat_dmg >= undeadHP && user_combat_dmg < (undeadHP * 2))
               {
                  undeadNum -= 1;
                  user_combat_dmg_float = (user_combat_dmg - undeadHP);
                  user_combat_dmg = 0;
                  System.out.println("1 Undead perishes!");
                  try
                  {
                     Thread.sleep(1000);
                  }
                  catch (InterruptedException ie)
                  {
                  }
               }
               if (user_combat_dmg >= (undeadHP * 2) && (user_combat_dmg < (undeadHP * 3)))
               {
                  undeadNum -= 2;
                  user_combat_dmg_float = (user_combat_dmg - (undeadHP * 2));
                  user_combat_dmg = 0;
                  System.out.println("2 Undead perish!");
                  try
                  {
                     Thread.sleep(1000);
                  }
                  catch (InterruptedException ie)
                  {
                  }
               }
               if (undeadHP_max <= 0)
               {
                  undeadNum = 0;
                  System.out.println("All enemies have been vanquished!");
                  System.out.println("You gain " + (enemy_count_max * undeadXP) + " experience!\n");
                  userXP += (enemy_count_max * undeadXP);
                  inCombat = 0;
                  path = 4;
                  user_combat_dmg = 0;
                  user_combat_dmg_float = 0;
                  enemy_count_max = 0;
                  break;
               }
               undeadHP_max = (undeadHP * undeadNum);
               undeadHP_max -= user_combat_dmg_float;
               user_combat_dmg_float = 0;
               System.out.println(undeadNum + " Undead remain!\n");
               try
               {
                  Thread.sleep(1000);
               }
               catch (InterruptedException ie)
               {
               }
               if (getRandom(1,100) < user_dodge)
               {
                  System.out.println("The (" + undeadNum + ") Undead swing and you DODGE! [" + user_dodge + "%]\n");
               }
               else
               {
                  user_hp -= (undeadDMG * undeadNum);
                  System.out.println("The (" + undeadNum + ") Undead swing dealing " + (undeadDMG * undeadNum) + " to you. " + user_hp + " health left!\n");
                  if (user_hp <= 0)
                  {
                     System.out.println("The Undead swing and inflict mortal wounds. You have died.\n");
                     System.out.println("Press enter to exit...");
                     Scanner keyboard = new Scanner(System.in);
                     String s = keyboard.nextLine();
                     if (s.equals(""))
                     {
                        System.exit(0);
                     }
                  }
               }
            }
         }
      }
   }
  
     while (path == 4)
     {
      System.out.println("\n\n As you approach the Abandoned City, you are pressed with a choice...");
      System.out.println("1. DEV TEST - Equip New Weapon");
      System.out.println("2. DEV TEST - Do Not Use");
      Scanner scan4 = new Scanner(System.in);
      while (!scan4.hasNextInt()) scan4.next(); //this prevents crash from user inputting letters
      temp_i = scan4.nextInt();        
      if (temp_i == 1)
      {
         if (inv_slot1 == 2)
         {
            System.out.println(userWeapon + " is already equipped.");
         }
         else 
         {
            userWeapon = "Lithar, Edge of Madness";
            System.out.println("You equip [" + userWeapon + "].");
            user_dmg += 250;
            System.out.println("Attack Damage: " + barb_str + " -> " + user_dmg + ".");
            inv_slot1 = 2;
         }
      }
      else if (temp_i == 2)
      {
         getBattle();
      }
      else if (temp_i == 3)
      {
         path = 6;
         temp_i = 0;
      }
      else 
      {
         System.out.println("Enter either \"1\", \"2\", or \"3\"");
         continue;
      } 
     }
  }
  public static int getRandom(int low, int high)
  {
    int temp = low + (int)(Math.random()*((high-low)+1));
    return temp;

  }
  public static void getBattle()
  {
   float mobType = 0f;
   Mob[] mobTable;
   mobTable = new Mob[getRandom(3,5)];
   for (int i = 0; i < mobTable.length; i++)
   {
      mobType = getRandom(1,100);
      if (mobType <= 55)
      {
         mobTable[i] = new Mob(20,"Skeleton");
      }
      else if (mobType < 80 && mobType >= 56)
      {
         mobTable[i] = new Mob(50,"Demon");
      }
      else if (mobType >= 80 && mobType < 99.5f)
      {
         mobTable[i] = new Mob(100,"Pit Fiend");
      }
      else if (mobType >= 99.5f)
      {
         mobTable[i] = new Mob(400,"Devil");
      }
      System.out.println(mobTable[i].mob_HP + " " + mobTable[i].mob_Name);
   }


   
  }

  
}

class Mob
{
   public int mob_HP;
   public String mob_Name;
   Mob(int mob_HP, String mob_Name)
   {
      this.mob_HP = mob_HP;
      this.mob_Name = mob_Name;
   }
}
      
   
/* Deviation 1 = path 1-3
        Hold 1 = path 4
   Deviation 2 = path 5-7   
        Hold 2 = path 8
   Deviation 3 = path 9-11
                           */