package com.zcg.studykotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test01() {
        var myList = listOf(1, 2, 3, 4)
        myList = myList.asSequence().filter {
            println("filter($it)")
            it > 2
        }.map {
            println("map($it)")
            it * 2
        }.toList()
        for (a in myList){
            print(a)
        }
    }

    fun test(): () -> Unit {
        var a = 0
        return fun() {
            a++
            println(a)
        }
    }
    @Test
    fun test02() {
        val a = 10
        val b = 15
        val max = if (a > b) {
            println("Choose a")
            a
        } else {
            println("Choose b")
            b
        }

        println(max)
    }

    fun getStringLength(obj: Any): Int? {
        if (obj !is String) return null

        // `obj` 在这一分支自动转换为 `String`，这是因为Kotlin的编译器帮我们做了转换
        // 这称为Kotlin中的智能转换(Smart Casts)。官方文档中这样介绍: 当且仅当Kotlin的编译器
        // 确定在类型检查后该变量不会再改变，才会产生Smart Casts。
        return obj.length
    }

    class Delegate1: ReadOnlyProperty<Any, String>{
        override fun getValue(thisRef: Any, property: KProperty<*>): String {
            return "通过实现ROP实现，name：${property.name}"
        }
    }

    class Delegate2: ReadWriteProperty<Any, Int>{
        override fun getValue(thisRef: Any, property: KProperty<*>): Int {
            return 20
        }

        override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
            println("委托是行为：${property.name} 委托值为： $value")
        }
    }

    class TestD {
        val d1: String by Delegate1()
        var d2: Int by Delegate2()
    }
    @Test
    suspend fun test03(){


    }
}