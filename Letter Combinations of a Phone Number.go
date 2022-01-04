var letters = [...]string{"", "", "abc", "def", "ghi", "jkl",
	"mno", "pqrs", "tuv", "wxyz"}

func letterCombinations(digits string) []string {
    if len(digits) == 0 {
		return nil
	}

	var result []string

    generateCombination("", digits, &result)

	return result
}

func generateCombination(current string, digits string, ans *[]string) {
	if len(digits) == 0 {
		*ans = append(*ans, current)
		return
	}

	currentDigit, _ := strconv.Atoi(string(digits[0]))

	for i := 0; i < len(letters[currentDigit]); i++ {
		generateCombination(current + string(letters[currentDigit][i]), digits[1:], ans)
	}
}
