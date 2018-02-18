import java.io.File;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class AnimalSequence {
	static boolean restartAsk;
	static boolean restart = true;
	static boolean enabled;
	static boolean enterPressed;
	static boolean replayAsked;
	static boolean dogPlayed;
	static boolean frogPlayed;
	static boolean catPlayed;
	static boolean pigPlayed;
	static boolean lionPlayed;
	static boolean horsePlayed;
	static boolean practice;
	static boolean startSounds;
	static boolean replay;
	static boolean animalAsk;

	public static int numAnimals = 0;
	public static int level = 1;
	public static int first = 0;
	public static int second = 0;
	public static int third = 0;
	public static int fourth = 0;
	public static int fifth = 0;
	public static int count = 0;

	public static Object sounds = new Object();
	public static Object AnimalObjects = new Object();
	public static Object playSequence = new Object();
	public static Object repeatSequence = new Object();
	public static Object practiced = new Object();
	public static Object restartGame = new Object();

	static File animalSounds = new File("animalSounds.wav");
	static File level2 = new File("level2.wav");
	static File level3 = new File("level3.wav");
	static File level4 = new File("level4.wav");
	static File level5 = new File("level5.wav");
	static File beatGame = new File("beatGame.wav");
	static File startOver = new File("startOver.wav");
	static File again = new File("again.wav");
	static File resetGame = new File("restart.wav");
	
	static File firstSound = new File("firstSound.wav");
	static File correctSecondSound = new File("correctSecondSound.wav");
	static File correctThirdSound = new File("correctThirdSound.wav");
	static File correctFourthSound = new File("correctFourthSound.wav");
	static File correctFifthSound = new File("fifthSound.wav");

	static File ready = new File("ready.wav");
	static File twoSounds = new File("2sounds.wav");
	static File threeSounds = new File("3sounds.wav");
	static File fourSounds = new File("4sounds.wav");
	static File fiveSounds = new File("5sounds.wav");
	
	static File two = new File("2.wav");
	static File three = new File("3.wav");
	static File four = new File("4.wav");
	static File five = new File("5.wav");
	static File six = new File("6.wav");
	static File seven = new File("7.wav");

	static File Cow = new File("Cow.wav");
	static File Dog = new File("Dog.wav");
	static File Horse = new File("Horse.wav");
	static File Cat = new File("Cat.wav");
	static File Lion = new File("Lion.wav");
	static File Pig = new File("Pig.wav");
	static File Frog = new File("Frog.wav");

	static File Repeat = new File("repeat.wav");
	static File Correct = new File("correct.wav");
	static File incorrect = new File("incorrect.wav");
	static File Wrong = new File("wrong.wav");
	static File Practice = new File("practice.wav");
	static File[] animals = { Cow, Dog, Horse, Cat, Lion, Pig, Frog };
	public static File[] arrayCopy = { Cow, Dog, Horse, Cat, Lion, Pig, Frog };
	static File numAnimalSounds = new File("numAnimals.wav");

	public static JButton cowButton = new JButton("Cow (1)");
	public static JButton dogButton = new JButton("Dog (2)");
	public static JButton horseButton = new JButton("Horse (3)");
	public static JButton catButton = new JButton("Cat (4)");
	public static JButton lionButton = new JButton("Lion (5)");
	public static JButton pigButton = new JButton("Pig (6)");
	public static JButton frogButton = new JButton("Frog (7)");
	public static JButton repeatButton = new JButton("Repeat (8)");
	public static JButton enterButton = new JButton("Enter");
	static String cowPath = Cow.getPath();
	static String dogPath = Dog.getPath();
	static String horsePath = Horse.getPath();
	static String catPath = Cat.getPath();
	static String lionPath = Lion.getPath();
	static String pigPath = Pig.getPath();
	static String frogPath = Frog.getPath();
	static String path;

	public static void main(String[] args) {
		  
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 3));
		frame.setLocation(440, 175);

		frame.setFocusable(true);
		frame.addKeyListener(new KeyListener() {
			long lastPressProcessed = 0;
			public void keyTyped(KeyEvent evt) {

			}

			@Override
			//conditionals to remove delay between button presses
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_1 || evt.getKeyCode() == KeyEvent.VK_NUMPAD1
						&& (System.currentTimeMillis() - lastPressProcessed > 2720 || dogPlayed || frogPlayed
								|| catPlayed || lionPlayed || pigPlayed || horsePlayed || enterPressed)) {
					lastPressProcessed = System.currentTimeMillis();
					cowButton.doClick();
					dogPlayed = false;
					frogPlayed = false;
					catPlayed = false;
					lionPlayed = false;
					pigPlayed = false;
					horsePlayed = false;
					enterPressed = false;
				}
				if (animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_2 || evt.getKeyCode() == KeyEvent.VK_NUMPAD2
							&& System.currentTimeMillis() - lastPressProcessed > 870) {
						lastPressProcessed = System.currentTimeMillis();
						dogButton.doClick();
					}
				}
				if (!animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_2 || evt.getKeyCode() == KeyEvent.VK_NUMPAD2
							&& (System.currentTimeMillis() - lastPressProcessed > 725 || frogPlayed || enterPressed)) {
						lastPressProcessed = System.currentTimeMillis();
						dogButton.doClick();
						dogPlayed = true;
						frogPlayed = false;
						catPlayed = false;
						lionPlayed = false;
						pigPlayed = false;
						horsePlayed = false;
						enterPressed = false;
					}
				}
				if (animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_3 || evt.getKeyCode() == KeyEvent.VK_NUMPAD3
							&& System.currentTimeMillis() - lastPressProcessed > 1020) {
						lastPressProcessed = System.currentTimeMillis();
						horseButton.doClick();
					}
				}
				if (!animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_3 || evt.getKeyCode() == KeyEvent.VK_NUMPAD3
							&& (System.currentTimeMillis() - lastPressProcessed > 2400 || dogPlayed || frogPlayed
									|| catPlayed || pigPlayed || enterPressed)) {
						lastPressProcessed = System.currentTimeMillis();
						horseButton.doClick();
						dogPlayed = false;
						frogPlayed = false;
						catPlayed = false;
						lionPlayed = false;
						pigPlayed = false;
						horsePlayed = true;
						enterPressed = false;
					}
				}
				if (animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_4 || evt.getKeyCode() == KeyEvent.VK_NUMPAD4
							&& System.currentTimeMillis() - lastPressProcessed > 910) {
						lastPressProcessed = System.currentTimeMillis();
						catButton.doClick();
					}
				}
				if (!animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_4 || evt.getKeyCode() == KeyEvent.VK_NUMPAD4
							&& (System.currentTimeMillis() - lastPressProcessed > 1400 || dogPlayed || frogPlayed
									|| enterPressed)) {
						lastPressProcessed = System.currentTimeMillis();
						catButton.doClick();
						dogPlayed = false;
						frogPlayed = false;
						catPlayed = true;
						lionPlayed = false;
						pigPlayed = false;
						horsePlayed = false;
						enterPressed = false;
					}
				}
				if (animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_5 || evt.getKeyCode() == KeyEvent.VK_NUMPAD5
							&& System.currentTimeMillis() - lastPressProcessed > 1020) {
						lastPressProcessed = System.currentTimeMillis();
						lionButton.doClick();
					}
				}
				if (!animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_5 || evt.getKeyCode() == KeyEvent.VK_NUMPAD5
							&& (System.currentTimeMillis() - lastPressProcessed > 2520 || dogPlayed || frogPlayed
									|| catPlayed || pigPlayed || horsePlayed || enterPressed)) {
						lastPressProcessed = System.currentTimeMillis();
						lionButton.doClick();
						dogPlayed = false;
						frogPlayed = false;
						catPlayed = false;
						lionPlayed = true;
						pigPlayed = false;
						horsePlayed = false;
						enterPressed = false;
					}
				}
				if (animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_6 || evt.getKeyCode() == KeyEvent.VK_NUMPAD6
							&& System.currentTimeMillis() - lastPressProcessed > 1020) {
						lastPressProcessed = System.currentTimeMillis();
						pigButton.doClick();
					}
				}
				if (!animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_6 || evt.getKeyCode() == KeyEvent.VK_NUMPAD6
							&& (System.currentTimeMillis() - lastPressProcessed > 1960 || dogPlayed || frogPlayed
									|| catPlayed || enterPressed)) {
						lastPressProcessed = System.currentTimeMillis();
						pigButton.doClick();
						dogPlayed = false;
						frogPlayed = false;
						catPlayed = false;
						lionPlayed = false;
						pigPlayed = true;
						enterPressed = false;
					}
				}
				if (!animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_7 || evt.getKeyCode() == KeyEvent.VK_NUMPAD7
							&& (System.currentTimeMillis() - lastPressProcessed > 740 || dogPlayed || enterPressed)) {
						lastPressProcessed = System.currentTimeMillis();
						frogButton.doClick();
						frogPlayed = true;
						dogPlayed = false;
						catPlayed = false;
						lionPlayed = false;
						pigPlayed = false;
						horsePlayed = false;
						enterPressed = false;
					}
				}
				if (animalAsk) {
					if (evt.getKeyCode() == KeyEvent.VK_7 || evt.getKeyCode() == KeyEvent.VK_NUMPAD7
							&& System.currentTimeMillis() - lastPressProcessed > 940) {
						lastPressProcessed = System.currentTimeMillis();
						frogButton.doClick();
					}
				}
				if (evt.getKeyCode() == KeyEvent.VK_8 || evt.getKeyCode() == KeyEvent.VK_NUMPAD8
						&& System.currentTimeMillis() - lastPressProcessed > 1000) {
					lastPressProcessed = System.currentTimeMillis();
					repeatButton.doClick();
					dogPlayed = false;
					frogPlayed = false;
					catPlayed = false;
					lionPlayed = false;
					pigPlayed = false;
					horsePlayed = false;
					enterPressed = false;
				}
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					enterButton.doClick();
					enterPressed = true;
					dogPlayed = false;
					frogPlayed = false;
					catPlayed = false;
					lionPlayed = false;
					pigPlayed = false;
					horsePlayed = false;
				}
			}

			@Override
			public void keyReleased(KeyEvent evt) {

			}
		});
		//Play animal sound, create String that is the name of the file, and enable enter button
		cowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaySound(Cow);
				path = cowPath;
				enterButton.setEnabled(true);
			}
		});
		dogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count == 0) {
					PlaySound(two);	//Play number sound when count is 0 and assign value to numAnimals
					numAnimals = 2;
				} else {
					PlaySound(Dog);
					path = dogPath;
				}
				enterButton.setEnabled(true);
			}
		});
		horseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count == 0) {
					PlaySound(three);
					numAnimals = 3;
				} else {
					PlaySound(Horse);
					path = horsePath;
				}
				enterButton.setEnabled(true);
			}
		});
		catButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count == 0) {
					PlaySound(four);
					numAnimals = 4;
				} else {
					PlaySound(Cat);
					path = catPath;
				}
				enterButton.setEnabled(true);
			}
		});
		lionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count == 0) {
					PlaySound(five);
					numAnimals = 5;
				}
				else {
					PlaySound(Lion);
					path = lionPath;
				}
				enterButton.setEnabled(true);
			}
		});
		pigButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count == 0) {
					PlaySound(six);
					numAnimals = 6;
				} else {
					PlaySound(Pig);
					path = pigPath;
				}
				enterButton.setEnabled(true);
			}
		});
		frogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count == 0) {
					PlaySound(seven);
					numAnimals = 7;
				}
				else {
					PlaySound(Frog);
					path = frogPath;
				}
				enterButton.setEnabled(true);
			}
		});
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// notify Objects when certain booleans are true
				if (practice) {
					synchronized (playSequence) {
						playSequence.notify();
					}
					count++;
				}
				if (numAnimals != 0 && count < 2) {
					synchronized (AnimalObjects) {
						AnimalObjects.notify();
					}
					count++;
				}
				if (replayAsked) {
					synchronized (repeatSequence) {
						replay = false;
						repeatSequence.notify();
					}
					count++;
				}
				if(restartAsk){
					synchronized(restartGame){
						restartGame.notify();
					}
					enterButton.setEnabled(false);
					restartAsk = false;
				}
				if (startSounds) {
					synchronized (sounds) {
						sounds.notify();
					}
					startSounds = false;
					count++;
				}

			}
		});
		repeatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (repeatSequence) {
					repeatButton.setEnabled(false);
					enterButton.setEnabled(false);
					replay = true;
					repeatSequence.notify();
				}
			}

		});

		frame.add(cowButton);
		frame.add(dogButton);
		frame.add(horseButton);
		frame.add(catButton);
		frame.add(lionButton);
		frame.add(pigButton);
		frame.add(frogButton);
		frame.add(repeatButton);
		frame.add(enterButton);

		frame.setVisible(true);
		while(restart){
		restart = false;
		enabled();
		animalAsk = true;
		//the number of animals chosen refers to the maximum number
		//of different animals that can play in a sequence
		PlaySound(numAnimalSounds);
		//when the number of animals chosen is > 5, the chances of 
		//playing different sounds in the last levels increases
		enabled();
		synchronized (AnimalObjects) {
			try {
				AnimalObjects.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		animalAsk = false;
		File[] random = randArray(arrayCopy, numAnimals);	//randomize array
		enabled();
		PlaySound(animalSounds);
		PlaySound(Practice);
		practice = true;
		enterButton.setEnabled(true);
		enabled();
		synchronized (playSequence) {
			try {
				playSequence.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		enabled();
		sounds(random);	//play sounds in random sequence
		PlaySound(Repeat);
		repeatButton.setEnabled(true);
		enterButton.setEnabled(true);
		replayAsked = true;
		synchronized (repeatSequence) {
			try {
				//disable the restart button when the repeat speech is
				//playing, then disable them when it is finished
				repeatSequence.wait();
				while (replay) {
					repeat(random);
					repeatButton.setEnabled(false);
					enterButton.setEnabled(false);
					PlaySound(Repeat);
					repeatButton.setEnabled(true);
					enterButton.setEnabled(true);
					replay = false;
					repeatSequence.wait();
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		replayAsked = false;
		practice = false;
		repeatButton.setEnabled(false);
		enterButton.setEnabled(false);
		PlaySound(firstSound);
		startSounds = true;
		enabled();
		synchronized (sounds) {
			try {
				enterButton.setEnabled(false);
				sounds.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		nextSound(random);
		}
	}

	public static void nextLevel(File[] array, int numAnimals) {
		randArray(array, numAnimals);

		if (level == 5) {
			PlaySound(fiveSounds);
		}
		if (level == 4) {
			PlaySound(fourSounds);
		}
		if (level == 3) {
			PlaySound(threeSounds);
		}
		if (level == 2) {
			PlaySound(twoSounds);
		}
		if (level == 1) {
			PlaySound(animalSounds);
		}
		PlaySound(ready);
		enterButton.setEnabled(true);
		enabled();
		practice = true;
		synchronized (playSequence) {
			try {
				playSequence.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		practice = false;
		enabled();
		sounds(array);
		PlaySound(Repeat);
		repeatButton.setEnabled(true);
		enterButton.setEnabled(true);
		replayAsked = true;
		synchronized (repeatSequence) {
			try {
				repeatSequence.wait();
				while (replay) {
					repeat(array);
					repeatButton.setEnabled(false);
					enterButton.setEnabled(false);
					PlaySound(Repeat);
					repeatButton.setEnabled(true);
					enterButton.setEnabled(true);
					replay = false;
					repeatSequence.wait();
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		replayAsked = false;
		repeatButton.setEnabled(false);
		enterButton.setEnabled(false);
		PlaySound(firstSound);
		startSounds = true;
		enabled();
		synchronized (sounds) {
			try {
				enterButton.setEnabled(false);
				sounds.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		nextSound(array);
	}

	public static File[] randArray(File[] array, int numAnimals) {
		Random rand = new Random();
		shuffleArray(array);		
		first = rand.nextInt(numAnimals);
		second = rand.nextInt(numAnimals);
		third = rand.nextInt(numAnimals);
		fourth = rand.nextInt(numAnimals);
		fifth = rand.nextInt(numAnimals);
		return array;
	}

	public static void nextSound(File[] random) {
		//conditionals for correct and incorrect answers
		//when incorrect, reset the variables and restart the game
		if (level == 5 && count > 0) {
			if (path.equals(random[first].getPath())) {
				beginSounds(correctSecondSound);
				synchronized (sounds) {
					try {
						enterButton.setEnabled(false);
						sounds.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				if (path.equals(random[second].getPath())) {
					beginSounds(correctThirdSound);
					synchronized (sounds) {
						try {
							enterButton.setEnabled(false);
							sounds.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					if (path.equals(random[third].getPath())) {
						beginSounds(correctFourthSound);
						synchronized (sounds) {
							try {
								enterButton.setEnabled(false);
								sounds.wait();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						if (path.equals(random[fourth].getPath())) {
							beginSounds(correctFifthSound);
							synchronized (sounds) {
								try {
									enterButton.setEnabled(false);
									sounds.wait();
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
							if (path.equals(random[fifth].getPath())) {
								levelUp(beatGame);
								restart = true;
								PlaySound(resetGame);
								restartAsk = true;
								synchronized (restartGame) {
									try {
										enterButton.setEnabled(true);
										restartGame.wait();
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									}
								}
								PlaySound(startOver);
								resetVariables();

							} else {
								incorrect(random, fifth);
							}
						} else {
							incorrect(random, fourth);
						}
					} else {
						incorrect(random, third);
					}
				} else {
					incorrect(random, second);
				}
			} else {
				incorrect(random, first);
			}
		}
		if (level == 4 && count > 0) {
			if (path.equals(random[first].getPath())) {
				beginSounds(correctSecondSound);
				synchronized (sounds) {
					try {
						enterButton.setEnabled(false);
						sounds.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				if (path.equals(random[second].getPath())) {
					beginSounds(correctThirdSound);
					synchronized (sounds) {
						try {
							enterButton.setEnabled(false);
							sounds.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					if (path.equals(random[third].getPath())) {
						beginSounds(correctFourthSound);
						synchronized (sounds) {
							try {
								enterButton.setEnabled(false);
								sounds.wait();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						if (path.equals(random[fourth].getPath())) {
							levelUp(level5);
						} else {
							incorrect(random, fourth);
						}
					} else {
						incorrect(random, third);
					}
				} else {
					incorrect(random, second);
				}
			} else {
				incorrect(random, first);
			}
		}
		if (level == 3 && count > 0) {
			if (path.equals(random[first].getPath())) {
				beginSounds(correctSecondSound);
				synchronized (sounds) {
					try {
						enterButton.setEnabled(false);
						sounds.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}

				if (path.equals(random[second].getPath())) {
					beginSounds(correctThirdSound);

					synchronized (sounds) {
						try {
							enterButton.setEnabled(false);
							sounds.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					if (path.equals(random[third].getPath())) {
						levelUp(level4);
					} else {
						incorrect(random, third);
					}
				} else {
					incorrect(random, second);
				}
			} else {
				incorrect(random, first);
			}
		}
		if (level == 2 && count > 0) {
			if (path.equals(random[first].getPath())) {
				beginSounds(correctSecondSound);

				synchronized (sounds) {
					try {
						enterButton.setEnabled(false);
						sounds.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				if (path.equals(random[second].getPath())) {
					levelUp(level3);
				} else {
					incorrect(random, second);
				}
			} else {
				incorrect(random, first);
			}
		}
		if (level == 1 && count > 0) {
			if (path.equals(random[first].getPath())) {
				levelUp(level2);
			} else {
				incorrect(random, first);
			}
		}
	}

	public static void repeat(File[] array) {
		//increment the number of sounds that play as the user
		//goes through each of the levels
		if(level == 1)
		{
			PlaySound(array[first]);
		}
		else if(level == 2)
		{
			PlaySound(array[first]);
			PlaySound(array[second]);
		}
		else if(level == 3){			
			PlaySound(array[first]);
			PlaySound(array[second]);
			PlaySound(array[third]);
		}
		else if(level == 4)
		{
			PlaySound(array[first]);
			PlaySound(array[second]);
			PlaySound(array[third]);
			PlaySound(array[fourth]);
		}
		else if(level == 5){
			PlaySound(array[first]);
			PlaySound(array[second]);
			PlaySound(array[third]);
			PlaySound(array[fourth]);
			PlaySound(array[fifth]);
		}
	}

	public static void sounds(File[] array) {
		repeat(array);
		//when the sequence is played, notify the user
		//that the sequence will be played again
		try {
			Thread.sleep(200);
			PlaySound(again);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repeat(array);
	}

	static void shuffleArray(File[] ar) {
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			File a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

	public static void incorrect(File[] array, int placement) {
		//Play the correct sound when the user's guess is wrong.
		while(!restart)
		{
		restart = true;
		enabled();
		PlaySound(Wrong);
		PlaySound(incorrect);
		PlaySound(array[placement]);
		PlaySound(resetGame);
		restartAsk = true;
		synchronized (restartGame) {
			try {
				enterButton.setEnabled(true);
				restartGame.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		PlaySound(startOver);
		resetVariables();
		}
	}
	public static void resetVariables(){
		numAnimals = 1;
		animalAsk = true;
		count = 0;
		level = 1;
		enabled();
	}
	static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			//Length of Thread sleeping time is dependent on length of sound clip
			if (clip.getMicrosecondLength() > 2000000) {
				Thread.sleep(clip.getMicrosecondLength() / 1000);
			} 
			else if(clip.getMicrosecondLength() > 1000000 && clip.getMicrosecondLength() < 2000000){
				Thread.sleep(clip.getMicrosecondLength()/850);
			}
			else {
				Thread.sleep(clip.getMicrosecondLength() / 700);
			}
		} catch (Exception e) {
		}
	}

	public static void enabled() {
		//enable and disable buttons
		if (!enabled) {
			cowButton.setEnabled(false);
			enterButton.setEnabled(false);
			repeatButton.setEnabled(false);
			dogButton.setEnabled(false);
			horseButton.setEnabled(false);
			catButton.setEnabled(false);
			lionButton.setEnabled(false);
			pigButton.setEnabled(false);
			frogButton.setEnabled(false);
			enabled = true;
		} else {
			dogButton.setEnabled(true);
			horseButton.setEnabled(true);
			catButton.setEnabled(true);
			lionButton.setEnabled(true);
			pigButton.setEnabled(true);
			frogButton.setEnabled(true);
			if (!animalAsk) {
				cowButton.setEnabled(true);
			}
			enabled = false;
		}
	}

	public static void beginSounds(File soundFile) {
		//ask for the next sound in the sequence when the user
		//is correct
		enabled();
		PlaySound(Correct);
		PlaySound(soundFile);
		startSounds = true;
		enabled();
		repeatButton.setEnabled(false);
	}

	public static void levelUp(File nextLevel) {
		//increment the user's level when it is completed
		//except for when it is the final level.
		enabled();
		PlaySound(Correct);
		PlaySound(nextLevel);
		level++;
		if (level < 6) {
			nextLevel(animals, numAnimals);
		}
	}
	}
	
