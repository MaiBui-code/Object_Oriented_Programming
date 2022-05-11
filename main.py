from IceCreamScoop import IceCreamScoop

def main():

   vanillaScoop:IceCreamScoop = IceCreamScoop( "vanilla" )

   vanillaScoop.addTopping( "sprinkles" )

   print( vanillaScoop )



   strawberryScoop:IceCreamScoop = IceCreamScoop( "strawberry" )

   strawberryScoop.melt()

   strawberryScoop.addTopping( "whipped cream" )

   print( strawberryScoop )



if __name__ == "__main__":

   main()