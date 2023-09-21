class car:
    'This class represents a car'
    def __init__(self, manufacturer,model, make, transmission, color ):
        self.manufacturer=manufacturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color

    def accelerate(self):
        abc=self.manufacturer
        print("{0} {1} is moving".format(abc, self.model))
    def stop(self):
        print("{1} {0} has stopped".format(self.manufacturer, self.model))

indigo=car( "Tata", 2016, "Tata", "Auto", "Grey")
indigo.accelerate()
indigo.stop()
innova=car( "Toyota", 2016, "Toyota", "Manual", "White")
innova.accelerate()
indigo.stop()
swift=car( "Maruthi", 2016, "Maruthi", "Auto", "Grey")
swift.accelerate()
indigo.stop()