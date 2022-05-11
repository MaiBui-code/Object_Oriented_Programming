from tkinter import Label
from EnchantedMushroom import EnchantedMushroom
class EnchantedLog (object):

    #class variable that will finally contain 2 images of the log: non-enchanted and enchanted 
    displayImages: list =[]
    
    #construct a log
    def __init__(self, guiElt: Label):

        #a property to check the status of enchantment
        self.__enchantment: bool = False

        #a property to track the status (enchanted or not) of all the mushrooms instnances
        self.__enchantedMushroom: list = []

        #a property to track the display image of the log
        self.__display: Label = guiElt

        #set up the image of the inital log: non-enchanted
        self.__display['image'] = EnchantedLog.displayImages[0]

        #set up the click 
        self.__display.bind( '<Button>', self.processClick)
    
    #a getter: get the level of enchantment

    def isEnchanted (self) -> bool:
        return self.__enchantment 
    
    #add mushrooms to the log
    def addMushroom(self, mushroom: EnchantedMushroom):
        self.__enchantedMushroom.append(mushroom)

    #enchant the log if all of the mushrooms have been enchanted
    def enchant (self) -> None:
        
        no_Enchanted = False
        #check if there is any non-enchanted mushroom
        for mushroom in self.__enchantedMushroom:
            if mushroom.getEnchantment() == 0:
                no_Enchanted = True
        #if all the mushroom has been enchanted -> enchant the log by refreshing the display 
        if not no_Enchanted:
            #we can enchant the log
            self.__enchantment = True
            #refresh the display of the log
            self.refreshDisplay()
        
    #refresh the display of the log
    def refreshDisplay(self):
        if self.isEnchanted:
            self.__display['image'] = EnchantedLog.displayImages[1]
        else:
            self.__display['image'] = EnchantedLog.displayImages[0]
        
    #function to describe the event after the click
    def processClick(self, event):
        #print the before the click
        print (f"Clicking {self}")

        #enchant the log
        self.enchant()

        #print the after the click
        print(f"... and now {self}")

    #string function to print out
    def __str__(self):
        if not self.isEnchanted():
            return f"A log that is not enchanted with {len(self.__enchantedMushroom)} mushrooms."
        else: 
            return f"A log that is enchanted with {len(self.__enchantedMushroom)} mushrooms."