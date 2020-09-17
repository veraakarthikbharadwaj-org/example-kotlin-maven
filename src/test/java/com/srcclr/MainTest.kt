package com.srcclr

import org.junit.Test
import java.net.HttpURLConnection
import java.net.URL

class MainTest {
    fun m1() {
        println("1")
    }

    fun m2() {
        println("2")
    }

    fun callM1() {
        for (i in 0..9) {
            m1()
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                System.err.println("oops1")
            }
        }
    }

    fun callM2() {
        for (i in 0..9) {
            m2()
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                System.err.println("oops2")
            }
        }
    }

    @Throws(InterruptedException::class)
    fun concurrency() {
        val t1 = Thread { callM1() }
        t1.name = "t1"
        t1.start()
        val t2 = Thread { callM2() }
        t2.name = "t2"
        t2.start()
        t1.join()
        t2.join()
    }

    private fun stdlib() {
        println("lol")
        m1()
        m2()
    }

    @Throws(Exception::class)
    private fun http() {
        val urlConnection = URL("http://www.google.com").openConnection() as HttpURLConnection
        println(urlConnection.requestMethod)
    }

    internal open class Animal {
        open fun call() {
            println("?")
        }
    }

    @Throws(Exception::class)
    private fun reflection() {
        val aClass = Class.forName(Animal::class.java.name)
        val t = aClass.newInstance()
        val allMethods = aClass.declaredMethods
        for (m in allMethods) {
            m.invoke(t)
        }
    }

    internal class Cat : Animal() {
        override fun call() {
            println("meow")
        }
    }

    private fun dynamicDispatch() {
        val a: Animal = Cat()
        a.call()
    }

    @Test
    @Throws(Exception::class)
    fun test() {
        stdlib()
        http()
        concurrency()
        reflection()
        dynamicDispatch()
        // For a test that uses a vulnerable method, see BCryptTest
    }
}