var convert = function (s, numRows) {
    // Base conditions
    if (s === null || numRows <= 0) {
        return "";
    }
    if (numRows === 1) {
        return s;
    }
    // Resultant String
    let result = ""
    // Step size
    const step = 2 * numRows - 2;
    // Loop for each row
    for (let i = 0; i < numRows; i++) {
        // Loop for each character in the row
        for (let j = i; j < s.length; j += step) {
            result += s[j];
            if (i != 0 && i != numRows - 1 && (j + step - 2 * i) < s.length) {
                result += s[j + step - 2 * i];
            }
        }
    }
    return result;
};
