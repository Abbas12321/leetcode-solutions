/**
 * @param {number} n
 * @return {number}
 */
var countOrders = function(n) {
    let count = 1
    const mod = 10 ** 9 + 7
    for (let i = 2; i <= n; i += 1) {
        count = ((2 * i * i - i) * count) % mod
    }
    return count
};
