This is a kata that asks you to add a new feature to a system. The problem is that the code is not quite maintainable and does not scale easily either so the first thing that you have to do is to refactor it and **then** make the addition.

Ofcaurse, since there are no tests, you need to add them **before** the refactoring to make sure that the system's behaviour does not change throughout the process.

Print and add this on your wall:

> for each desired change, make the change easy (warning: this may be hard), then make the easy change
>
> -- Kent Beck [(tweet)](https://twitter.com/kentbeck/status/250733358307500032?lang=en)

#### Source / Αttribution

The original kata is written in C# by [@TerryHughes](https://twitter.com/TerryHughes) and [@NotMyself](https://twitter.com/NotMyself) and can be found at [https://github.com/NotMyself/GildedRose](https://github.com/NotMyself/GildedRose).

## Gilded Rose Refactoring Kata

*(copy and pasted from the original)*

Hi and welcome to team Gilded Rose.

As you know, we are a small inn with a prime location in a prominent city ran by a friendly innkeeper named Allison. 
We also buy and sell only the finest goods. Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We have a system in place that updates our inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures.

Your task is to add the new feature to our system so that we can begin selling a new category of items.

### First an introduction to our system

- All items have a SellIn value which denotes the number of days we have to sell the item
- All items have a Quality value which denotes how valuable the item is
- At the end of each day our system lowers both values for every item

Pretty simple, right?

### Well this is where it gets interesting

- Once the sell by date has passed, Quality degrades twice as fast
- The Quality of an item is never negative
- "Aged Brie" actually increases in Quality the older it gets
- The Quality of an item is never more than 50
- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
- "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

### New feature

We have recently signed a supplier of conjured items.
This requires an update to our system:

- "Conjured" items degrade in Quality twice as fast as normal items

### Restrictions

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything still works correctly. 
However, do not alter the Item class or Items property as those belong to the goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover for you).

Just for clarification, an item can never have its Quality increase above 50, 
however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.

## About this repository

The master branch has an untested GildedRose class waiting to be refactored and updated with the new requirements!
The *practise_kata_n* branches will have my implementations for every time I practise the kata.