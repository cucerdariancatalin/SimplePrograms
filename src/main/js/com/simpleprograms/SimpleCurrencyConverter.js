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

const input = require('sync-input');

class Currency {
    constructor(name, rate) {
        this.name = name;
        this.rate = rate;
    }
}

const currencies = [
    new Currency("USD", 1),
    new Currency("JPY", 113.5),
    new Currency("EUR", 0.89),
    new Currency("RUB", 74.36),
    new Currency("GBP", 0.75)
];

run();

function run() {
    greet();

    while (true) {
        console.log("What do you want to do?");
        console.log("1-Convert currencies 2-Exit program");

        switch (input()) {
            case "1":
                showConversionDialog();
                break;
            case "2":
                console.log("Have a nice day!");
                return;
            default:
                console.log("Unknown input");
        }
    }
}

function greet() {
    console.log("Welcome to Currency Converter!");
    currencies.forEach(function (value) {
        console.log(`1 USD equals ${value.rate} ${value.name}`)
    });
}

function showConversionDialog() {
    console.log("What do you want to convert?");

    console.log(`From:`);
    const currencyFrom = defineCurrency(input().toUpperCase());
    if (!validateCurrency(currencyFrom)) {
        return;
    }

    console.log(`To:`);
    let currencyTo = defineCurrency(input().toUpperCase());
    if (!validateCurrency(currencyTo)) {
        return;
    }

    console.log("Amount:");
    const amount = Number(input());
    if (!validateAmount(amount)) {
        return;
    }

    console.log(`Result: ${amount} ${currencyFrom.name} equals ${convert(currencyFrom, currencyTo, amount).toFixed(4)} ${currencyTo.name}`);
}

function convert(currencyFrom, currencyTo, amount) {
    if (currencyFrom === currencyTo) {
        return amount;
    }

    return (amount / currencyFrom.rate) * currencyTo.rate;
}

function defineCurrency(currency) {
    for (let index in currencies) {
        if (currencies[index].name === currency) {
            return currencies[index];
        }
    }

    return null;
}

function validateCurrency(currency) {
    if (currency === null) {
        console.log("Unknown currency");
        return false;
    }

    return true;
}

function validateAmount(amount) {
    if (isNaN(amount)) {
        console.log("The amount has to be a number");
        return false;
    } else if (amount < 1) {
        console.log("The amount cannot be less than 1");
        return false;
    } else {
        return true;
    }
}
