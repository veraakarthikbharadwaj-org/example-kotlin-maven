package com.srcclr

import org.apache.commons.fileupload.MultipartStream
import org.apache.xml.security.signature.XMLSignatureInput
import org.mindrot.jbcrypt.BCrypt
import org.springframework.web.util.UriUtils
import java.io.ByteArrayInputStream


fun main(args: Array<String>) {
    val candidate = args[0]
    val hashed = BCrypt.hashpw(candidate, BCrypt.gensalt(12))

    BCrypt.checkpw(candidate, hashed)

    filterXMLSignature()

    // Update Advisor: changed in the upgrade from Spring Web 3.1.1.RELEASE to 3.2.15.RELEASE

    // Update Advisor: changed in the upgrade from Spring Web 3.1.1.RELEASE to 3.2.15.RELEASE
    UriUtils.encodeFragment("", "")
}

fun filterXMLSignature() {
    val bytes = ByteArray(256)
    MultipartStream(ByteArrayInputStream(bytes), bytes)
    XMLSignatureInput(bytes).addNodeFilter(null)
}