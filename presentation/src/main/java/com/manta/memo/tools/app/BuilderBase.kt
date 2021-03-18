package com.manta.memo.tools.app

interface BuilderBase {
}

fun <T : BuilderBase> T.set(f : T.() -> Unit) : T{
    f()
    return this
}