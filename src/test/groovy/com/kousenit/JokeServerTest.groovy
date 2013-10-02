package com.kousenit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class JokeServerTest {
    JokeServer server = JokeServer.instance

    @Test
    public void testGetJokeFirstNameLastName() {
        String joke = server.getJoke('Patton', 'Boggs')
        assert !joke.contains('Chuck')
        assert !joke.contains('Norris')
        assert joke.contains('Patton')
        assert joke.contains('Boggs')
        println joke
    }

    @Test
    public void testGetJoke() {
        String joke = server.joke
        println joke
        assert joke
    }

}
