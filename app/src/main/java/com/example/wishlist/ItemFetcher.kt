package com.example.wishlist

class ItemFetcher {
    companion object {

        var wishItems: MutableList<Item> = mutableListOf()

        fun getItems(): List<Item> {

            return wishItems
        }

        fun getItem(idx: Int): Item {

            return wishItems[idx]
        }

        fun setItems(item: Item){
            wishItems.add(item)
        }

    }
}
