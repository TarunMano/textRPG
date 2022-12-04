import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[]args) {
		
		
		//Scanner
		Scanner inp = new Scanner(System.in);
		Random rand = new Random();
		
		//Variable Games
		String[] enemies = { "Warrior", "Mage", "Assasin", "Archer" }; //Enemies List
		String[] powers = { "Fireball", "Tornado", "Tsunami", "Earthquake" }; //Powers List
		String[] bosses = {"!DRAGON LORD!", "!ARMY OF THE DEAD!", "!MAGE LORD!", "!WARRIOR KING!", "!GOD OF THE GIANTS!" }; //Boss List
		int maxEnemyHealth = 150; //Max enemy health
		int minEnemyHealth = 50;
		int maxEnemyAttack = 35; //Max enemy attack
		int bossHealth = 500; //Boss health
		int bossAttack = 75; // Max boss attack
		int bossAttackMin = 35; // Minimum boss attack
		int bossAttackPct = 35; // boss attack percentage
		int scoreMultiply = 300; //max score received
		int scoreMultiplyMin = 100; //minimum score received
		int bossScoreMultiply = 1500; // max boss score
		int bossScoreMultiplyMin = 900; // minimum boss score
		int damageDealt = 0; //damage dealt to enemy
		int bossDamageDealt = 0; //damage dealt to boss
		int bossAppChnce = 75; //chance of boss appearing
		
		// Player Variables
		int health = 250; //max health
		int playerAttack = 150; // player attack damage
		int numHealthPots = 5; //# of health pots
		int healthPotionNum = 45; //how much pot heals
		int powerLevelMax = 100; //power charge up
		int powerLevel = 0; // power level
		int dropChanceHealthPot = 65; //% drop
		int powerAttack = 300; // power attack damage
		int powerAttackMin = 150; // minimum power attack damage
		int critPct = 75; //Critical percentage chance
		int critDmgMax = 150; //Maximum Critical damage
		int critDmgMin = 125; //Minimum Critical damage
		int score = 0; //Score
		
		boolean running = false; 
		boolean title = true;
		
		TITLE:
		while(title) {	
			System.out.println("Welcome Brave Adventurer");
			System.out.println("This is the Dungeon.");
			System.out.println("Click an option: ");
			System.out.println("\n\t1: Enter the Dungeon.");
			System.out.println("\t2: Learn about the Dungeon.");
			System.out.println("\t3: Leave the Dungeon");
			
			String inputB = inp.nextLine();
			
			if(inputB.equals("1")) {
				System.out.println("\nGood Luck");
				running = true;
				break TITLE;
			}
			else if(inputB.equals("2")) {
				System.out.println("\nThe Dungeon is a cave crawling with enemies you, as the Chosen One, must defeat as many as possible.");
				System.out.println("You must defeat as many enemies until you leave or die.");
				System.out.println("\nEnemies: Warrior, Mage, Asassin, Archer.");
				System.out.println("\nFighting a certain amount of enemies may trigger a boss appearing.");
				System.out.println("\nBosses: Dragon Lord, Army of the Dead, Mage Lord, Warrior King, God of  the Giants");
				System.out.println("\nTo defeat any enemies or bosses choose the option to attack do a random amount of damage");
				System.out.println("\nRack up your power level by defeating enemies and attacking bosses.");
				System.out.println("Reach a power level of 100 to launch a devastating blow.");
				System.out.println("\nWhen you are low on health, use a health potion to heal up");
				System.out.println("Defeating enemies grant the chance at more health potions.");
				System.out.println("\n Rack up as much score as possible.");
				System.out.println("----------------------------------");
				continue TITLE;
				
			}
			else if(inputB.equals("3")) {
				title = false;
				
			}
			else if(!inputB.equals("1")||!inputB.equals("2")||inputB.equals("3")) {
				System.out.println("Invalid Command.");
			}
			else {
				System.out.println("");
			}
		
		}
		GAME:
		while(running) {
			
			System.out.println("----------------------------------");
			if(score >= 550) {
				if(rand.nextInt(100) < bossAppChnce) {
					String boss = bosses[rand.nextInt(bosses.length)];
					System.out.println("\n||>>> THE " + boss + " HAS APPEARED <<<||");
					System.out.println("|You have " + health + " HP.|");
					System.out.println("|You have " + numHealthPots + " health potions.|");
					System.out.println("|Would you like to use one?");
					System.out.println("\n\t 1: Yes?");
					System.out.println("\n\t 2: No?");
					String bossInput1 = inp.nextLine();
					if(bossInput1.equals("1")) {
						if(numHealthPots > 0) {
							health += healthPotionNum;
							numHealthPots--;
							System.out.println("\t> You drink a health potion, you have healed yourself for " + healthPotionNum +
												"." + "\n\t> You now have " + health + " HP"
												+ "\n\t> You now have " + numHealthPots + " health potions left. \n");
							
						}
						else {
							System.out.println("\t> You have no health potions left. Good Luck.");
						}
						
					}
					else if(bossInput1.equals("2")) {
						System.out.println("\t>Good Luck.");
					}
					else if(!bossInput1.equals("1")||!bossInput1.equals("2")){
						System.out.println("Invalid Command.");
					}
					else {
						System.out.println("");
					}
					BOSS:
					while (bossHealth > 0) {
						System.out.println("\n\tChoose an option." );
						System.out.println("\t1: Attack.");
						System.out.println("\t2: Use Power.");
						System.out.println("\t3: Use Potion.");
						System.out.println("\t4: Run.");
						
						String bossInput2 = inp.nextLine();
						if(bossInput2.equals("1")) {
							int critPctActual = rand.nextInt(critPct);
							if(rand.nextInt(100) < critPctActual) {
								bossDamageDealt = rand.nextInt(critDmgMax - critDmgMin) + critDmgMin;
								System.out.println("\t>CRITICAL HIT!!");
							}
							else {
								bossDamageDealt = rand.nextInt(playerAttack);
							}
							if(rand.nextInt(100) < bossAttackPct) {
								int bossDamageTaken = rand.nextInt(bossAttack - bossAttackMin) + bossAttackMin;
								health -= bossDamageTaken;
								System.out.println("\tThe " + boss + " has dealt a devastating blow for " + bossDamageTaken + " damage.");
							}
							 
							bossHealth -= bossDamageDealt;
							powerLevel += rand.nextInt(powerLevelMax);
							
							System.out.println("\t> You Strike the " + boss + " for " + bossDamageDealt + " damage.");
							System.out.println("\n|You have " + health + " HP left.|");
							System.out.println("|Your power level is  " + powerLevel + ".|");
							System.out.println("|The " + boss + " has " + bossHealth + " left.|");
							
							
							if(health < 1) {
								System.out.println("\t>You have recieved too much damage to go on.");
								break GAME;
							}
						}
				        if(bossInput2.equals("2")){
				          if(powerLevel< 100){
				            System.out.println("\t>You are too weak for this right now.");
				          }
				          else{
				            String power = powers[rand.nextInt(powers.length)];
				            int powerDamage = rand.nextInt(powerAttack - powerAttackMin) + powerAttackMin;
				            bossHealth -=powerDamage;
				            powerLevel -= 100;
				            System.out.println("\t<You have used " + power + " on " + boss + " for " + powerDamage +   ".");
				          }
				      
				        }
						else if(bossInput2.equals("3")) {
							if(numHealthPots > 0) {
								System.out.println("\tYou have " + numHealthPots + ". Would you like to use one?");
								System.out.println("\n\t>1: Yes?");
								System.out.println("\n\t>2: No?");
								String bossInput3 = inp.nextLine();
								
								if(bossInput3.equals("1")) {
									health += healthPotionNum;
									numHealthPots--;
									System.out.println("\t> You drink a health potion, you have healed yourself for " + healthPotionNum +
														"." + "\n\t> You now have " + health + " HP"
														+ "\n\t> You now have " + numHealthPots + " health potions left. \n");
								}
								else if(bossInput3.equals("2")) {
									System.out.println("\t Ok");
									
									
								}
								else if(!bossInput3.equals("1")||!bossInput3.equals("2")) {
									System.out.println("Invalid Command");
								}
								else {
									System.out.println("");
								}
								
							}
							else {
								System.out.println("\t> You have no health potions left.");
							}
							
						}
						else if(bossInput2.equals("4")) {
							System.out.println("\tYou are unable to run away!");
							continue BOSS;
							
						}
						else if (!bossInput2.equals("1")||!bossInput2.equals("2")||!bossInput2.equals("3")||!bossInput2.equals("4") ){
							System.out.println("\t Invalid Command");
							
						}
						else {
							System.out.println("");
						}
						
						
					}
					if(bossHealth < 1 ) {
						int bossScoreAdd  = rand.nextInt(bossScoreMultiply - bossScoreMultiplyMin) + bossScoreMultiplyMin;
						score += bossScoreAdd;
						System.out.println("\nYou have slayed the " + boss + "!");
						System.out.println("Congratulations");
						System.out.println("");
						
						
						
								
					}
					
				}
				else {
					System.out.println("");
				}
				
			}
			
			int enemyHealth = rand.nextInt(maxEnemyHealth - minEnemyHealth) + minEnemyHealth;
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# a " + enemy + " appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " +health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tChoose an option." );
				System.out.println("\t1: Attack.");
				System.out.println("\t2: Use Power.");
				System.out.println("\t3: Use Potion.");
				System.out.println("\t4: Run.");
				
				String input = inp.nextLine();
				if(input.equals("1")) {
					int critPctActual = rand.nextInt(critPct);
					if(rand.nextInt(100) <= critPctActual) {
						damageDealt = rand.nextInt(critDmgMax - critDmgMin) + critDmgMin;
						System.out.println("\t>CRITICAL HIT!!");
					}
					else {
						damageDealt = rand.nextInt(playerAttack);
					}
					
					
					int damageTaken = rand.nextInt(maxEnemyAttack);
					
					
					 
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You Strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You recieve " + damageTaken + " in retaliation.");
					powerLevel += rand.nextInt(powerLevelMax);
					System.out.println("\t# Your Power Level is now " + powerLevel + ". # ");
					
					if(health < 1) {
						System.out.println("\t>You have recieved too much damage to go on.");
						break GAME;
					}
				}
		        if(input.equals("2")){
		          if(powerLevel< 100){
		            System.out.println("\t>You don't have enough power for this yet.");
		          }
		          else{
		            String power = powers[rand.nextInt(powers.length)];
		            int powerDamage = rand.nextInt(powerAttack - powerAttackMin) + powerAttackMin;
		            enemyHealth -=powerDamage;
		            powerLevel -= 100;
		            System.out.println("\t<You have used " + power + " on " + enemy + " for " + powerDamage +   ".");
		          }
		      
		        }
				else if(input.equals("3")) {
					if(numHealthPots > 0) {
						System.out.println("\tYou have " + numHealthPots + ". Would you like to use one?");
						System.out.println("\n\t>1: Yes?");
						System.out.println("\n\t>2: No?");
						String input2 = inp.nextLine();
						
						if(input2.equals("1")) {
							health += healthPotionNum;
							numHealthPots--;
							System.out.println("\t> You drink a health potion, you have healed yourself for " + healthPotionNum +
												"." + "\n\t> You now have " + health + " HP"
												+ "\n\t> You now have " + numHealthPots + " health potions left. ");
						}
						else if(input2.equals("2")) {
							System.out.println("\t Ok");
							
							
						}
						else if(!input2.equals("1")||!input2.equals("2")) {
							System.out.println("Invalid Command");
						}
						else {
							System.out.println("");
						}
					
				    }
					else if(numHealthPots < 1){
						System.out.println("\n\t> You don't have any potions. Defeat an enemy for a chance at one.");
					}
					else {
						System.out.println("");
					}
				}
					
				else if(input.equals("4")) {
					System.out.println("\tYou have run away from the " + enemy + "!");
					continue GAME;
					
				}
				else if(!input.equals("1")||!input.equals("2")||!input.equals("3")||!input.equals("4")){
					System.out.println("\t Invalid Command");
					
				}
				else {
					System.out.println("");
				}
			}
			
			if(health < 1) {
				System.out.println("You have died in the Dungeon.");
				System.out.println("\nYour final score was: " + score + ".");
				inp.close();
				break;
			}
			
			
			System.out.println("----------------------------------");
			System.out.println(" # " + enemy + " was defeated! #");
			System.out.println(" # You have " + health + " HP left. #");
			int scoreAdd  = rand.nextInt(scoreMultiply - scoreMultiplyMin) + scoreMultiplyMin;
			score += scoreAdd;
			System.out.println(" # Your Score is now: " + score + ". # ");
			if(rand.nextInt(100) < dropChanceHealthPot) {
				numHealthPots++;
				System.out.println(" # The " + enemy + " dropped a health potion! # ");
				System.out.println(" # You now have " + numHealthPots + " health potion(s) # ");
				
				
			}
			System.out.println("----------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1: Continue fighting?");
			System.out.println("2: Flee the Dungeon?");
			
			String input3 = inp.nextLine();
			
			while(!input3.equals("1") && !input3.equals("2")) {
				System.out.println("Invalid Command");
				input3 = inp.nextLine();
			}
			
			if(input3.equals("1")) {
				System.out.println("You continue on.");
			}
			else if(input3.equals("2")) {
				System.out.println("");
				System.out.println("You exit the Dungeon alive.");
				System.out.println("\nYour final score was: " + score + ".");
				
				break GAME;
			}
			
			
		}
		
		System.out.println("\n############################");
		System.out.println("#         The End.         #");
		System.out.println("############################");
		
	}
}		
   	

 

