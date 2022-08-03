/*
 * MIT License
 *
 * Copyright (c) 2022 Ivan Bobrov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
 * whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.simpleprograms

/**
 * Prints a list of orders in the console
 *
 * @author Ivan Bobrov
 * @version 1.0.1
 */
// Create and add order directly using builder pattern and print all orders
fun main() {
    val ordersList: MutableList<Order> = mutableListOf()

    ordersList.add(
        Order(1)
            .addItem(Noodles())
    )

    ordersList.add(
        Order(2)
            .addItem(Noodles())
            .addItem(Vegetables())
    )

    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    ordersList.add(
        Order(3)
            .addAll(items)
    )

    ordersList.add(
        Order(4)
            .addItem(Noodles())
            .addItem(Noodles())
            .addItem(Vegetables("Spinach"))
    )

    // Print out each order
    for (order in ordersList) {
        order.printOrder()
        println()
    }
}

/**
 * One of the item in the order
 */
open class Item(val name: String, val price: Int) {
    override fun toString(): String {
        return "$name: $$price"
    }
}

/**
 * An item "Noodles" costs $10
 */
class Noodles : Item("Noodles", 10)

/**
 * An item „Vegetables” costs $5 and can consist of some types
 */
class Vegetables(private vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return if (toppings.isEmpty()) {
            "$name Chef's Choice"
        } else {
            "$name ${toppings.joinToString(" ")}: $$price"
        }
    }
}

/**
 * Visitor's order
 */
class Order(private val orderNumber: Int) {
    // List of visitor's items
    private val itemList: MutableList<Item> = mutableListOf()

    // Add one item to order
    fun addItem(newItem: Item): Order {
        itemList.add(newItem)
        return this
    }

    // Add all items from list to order
    fun addAll(newItems: List<Item>): Order {
        itemList.addAll(newItems)
        return this
    }

    // Print visitor's order
    fun printOrder() {
        var total = 0
        println("Order #$orderNumber")
        for (i in itemList) {
            total += i.price
            println(i.toString())
        }
        println("Total: $$total")
    }
}
