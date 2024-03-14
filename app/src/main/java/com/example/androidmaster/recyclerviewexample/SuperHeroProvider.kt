package com.example.androidmaster.recyclerviewexample

class SuperHeroProvider {
    companion object {

        val superHeroList = listOf<SuperHero>(
                SuperHero("Batman", "DC Comics", "Bruce Wayne", "https://www.superherodb.com/pictures2/portraits/10/100/639.jpg"),
                SuperHero("Superman", "DC Comics", "Clark Kent", "https://www.superherodb.com/pictures2/portraits/10/100/791.jpg"),
                SuperHero("Spiderman", "Marvel Comics", "Peter Parker", "https://www.superherodb.com/pictures2/portraits/10/100/133.jpg"),
                SuperHero("Ironman", "Marvel Comics", "Tony Stark", "https://www.superherodb.com/pictures2/portraits/10/100/85.jpg"),
                SuperHero("Deadpool", "Marvel Comics", "Wade Wilson", "https://www.superherodb.com/pictures2/portraits/10/100/835.jpg"),
                SuperHero("Hulk", "Marvel Comics", "Bruce Banner", "https://www.superherodb.com/pictures2/portraits/10/100/83.jpg"),
                SuperHero("Thor", "Marvel Comics", "Thor Odinson", "https://www.superherodb.com/pictures2/portraits/10/100/140.jpg")
            )

    }
}