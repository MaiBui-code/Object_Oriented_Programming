class SlotMachine (object):
    #construct the slot machine that has 1 instance property: reels number result: reelNumber
    def __init__(self, reel1stRound: str, reel2ndRound: str, reel3rdRound: str):
        self.__reel1stRound = reel1stRound
        self.__reel2ndRound = reel2ndRound
        self.__reel3rdRound = reel3rdRound
        self.__payout = 0
    #play method to compute the money corresponding to the number of the Reel
    def play(self) -> str:
        #case 1: all the numbers are the same and different than $
        if (self.__reel1stRound == self.__reel2ndRound == self.__reel3rdRound) and (self.__reel1stRound != "$"):
            #return the payout as the number of the same reel
            return self.__reel1stRound
        #case 2: all the numbers are the same and are $
        elif (self.__reel1stRound == self.__reel2ndRound == self.__reel3rdRound) and (self.__reel1stRound == "$"):
            #return the payout as the special price: 1000!!!
            return 1000
        #case 3: all the numbers are different
        else:
            #return the payout as $0 :((
            return 0 
    def __str__(self) -> str:    
        #print the result
        return f"You got {self.__reel1stRound}{self.__reel2ndRound}{self.__reel3rdRound} with a payout of {self.play()}"

