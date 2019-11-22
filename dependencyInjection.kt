/**

Scenario: A robot can create wall with wooden bar/beam. But when it has install the door, 
it just take a pre-manufactured door instead of making it
and install it on the wall. 

So, the wall constructor take a door type object and use it during the construction.
But door can be of different type, like plastic, wood etc. But robot doesn't have to be 
worried about as it is provided as constructor

This external providing is known as dependency injection (DI)

****/

class Main{
  fun main(){
    val plasticDoor = PlasticDoor(5, "plastic")
    val wall = Wall(plasticDoor)
    wall.makeWall()
  }
}
interface wallable{
    fun getEngraving(): Int
}

class Wall(val door:Door){

    fun makeWall(){
        putWoodenBar(1)
        putWoodenBar(2)
        putDoor(door)
        putWoodenBar(3)
        putWoodenBar(4)
    }

    private fun putWoodenBar(i: Int) {
        print(i)
    }

    private fun putDoor(door: Door){
        print(door.id)
    }

}

abstract class Door(val id:Int):wallable{
    override fun getEngraving(): Int {
        return id
    }
}



class PlasticDoor(id:Int, val material:String):Door(id){

}

class WoodenDoor(id:Int, val material:String):Door(id){

}
