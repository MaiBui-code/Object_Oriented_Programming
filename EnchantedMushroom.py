from tkinter import Label

class EnchantedMushroom (object):
    
    #initiate a list that utimately will contain 4 images
    displayImages: list = []

    #constructor
    def __init__ (self, guiElt: Label):
        
        # 1st property: An int to track the enchantment level of the mushroom, with 0 indicating no enchantment
        self.__enchantLevel: int = 0

        # 2nd property: A Label to maintain the display for the mushroom
        self.__display: Label = guiElt

        """ personal note: when we initialize it, we just set up the background info: the position, background color,
         window for attachement. Thus, the next code, we need to set the image to display it on the background """

        # set up the GUI to start by displaying the image of mushroom (without enchanted)
        self.__display["image"] = EnchantedMushroom.displayImages[0]

        #Should  "bind" mouse click events to the instance method processClick
        self.__display.bind( "<Button>", self.processClick )

    #getter: getEnchantment
    def getEnchantment(self) -> int:

        return self.__enchantLevel

    #setter: setEnchantment
    def setEnchantment(self, level: int) -> None:

        #Checks if the given value is valid
        if level<0:
            self.__enchantLevel = 0
        elif level >= len(EnchantedMushroom.displayImages):
            self.__enchantLevel = len(EnchantedMushroom.displayImages) -1
        else:
            self.__enchantLevel = level
        
        #refresh the display of the new enchant level
        self.refreshDisplay()

    #enchant
    def enchant(self) -> None:
        self.setEnchantment(self.getEnchantment() + 1)

    #process Click
    def processClick (self,event) -> None:
        
        #print info so we know the Click occured
        print( f"Clicking {self}")

        #change the state of the mushroom/enchant the mushroom
        self.enchant()

        #print info now that the state has changed
        print ( f"... and now{self}")

    #refresh Display to update the new picture of enchanted Mushroom
    def refreshDisplay(self) -> None:
        
        #update the displayed image to be the corresponding image in the displayImages list.
        self.__display["image"] = EnchantedMushroom.displayImages[self.__enchantLevel]

    #string function
    def __str__(self):
        return f"A mushroom enchanted at level {self.__enchantLevel}."


