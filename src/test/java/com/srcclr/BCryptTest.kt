package com.srcclr

import junit.framework.TestCase
import org.junit.Test
import org.mindrot.jbcrypt.BCrypt

@Test
fun testInternationalChars() {
    print("BCrypt.hashpw w/ international chars: ")
    val pw1 = "ππππππππ"
    val pw2 = "????????"
    val h1 = BCrypt.hashpw(pw1, BCrypt.gensalt())
    TestCase.assertFalse(BCrypt.checkpw(pw2, h1))
    print(".")
    val h2 = BCrypt.hashpw(pw2, BCrypt.gensalt())
    TestCase.assertFalse(BCrypt.checkpw(pw1, h2))
    print(".")
    println("")
}