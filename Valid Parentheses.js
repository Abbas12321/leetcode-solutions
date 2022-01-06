var isValid = function(s) {
  const input = s.split('');
  const opening = ['(', '{', '['];
  const closing = [')', '}', ']'];

  const result = [];

  for (let i = 0; i < input.length; i++) {
    if (opening.includes(input[i])) {
      result.push(input[i]);
    } else if (closing.includes(input[i])) {
      const pos = closing.indexOf(input[i]);
      if (result.length === 0 || result[result.length - 1] !== opening[pos]) {
        return false;
      } else {
        result.pop();
      }
    }
  }
  return result.length === 0;
};
