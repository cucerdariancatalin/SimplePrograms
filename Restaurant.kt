/**
 * Run the program that prints a list of orders in the console
 *
 * @author VitasSalvantes
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