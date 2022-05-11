class IceCreamScoop(object):

   """ Represents a single scoop of ice cream. Mmmm. Ice cream. """

  

   def __init__( self, flav:str ):

       """ Constructor (special method that must have the __init__ identifier)

       creates a new ice cream scoop with the specified flavor. """



       # initialize an instance property to hold the flavor

       self.__flavor:str = flav



       # initialize the toppings list, which starts of empty

       self.__toppings:list = []



       # initialize that the scoop is not melted

       self.__melted:bool = False

  

   def melt( self ) -> None:

       """ Melt this scoop of ice cream :( """

       # update the instance property accordingly

       self.__melted = True

  

   def addTopping( self, topping:str ) -> None:

       """ Add the topping to this scoop's toppings. """

       self.__toppings.append( topping )

  

   def __str__( self ) -> str:

       """ Return a string representation of this ice cream scoop.

       By using the special identifier __str__, this will allow us to

       associate it with the str function (or simply print). """



       basicDescription:str = f"This {self.__flavor} ice cream scoop, topped with {self.__toppings}"

       if self.__melted:

           return basicDescription + " has melted :("

       else:

           return basicDescription + " has not melted!"