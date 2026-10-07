class Solution:
    def removeInvalidParentheses(self, s):
        result = set()

        def is_valid(string):
            count = 0

            for ch in string:
                if ch == '(':
                    count += 1
                elif ch == ')':
                    count -= 1

                    if count < 0:
                        return False

            return count == 0

        def backtrack(index, current, removals):
            if removals == 0:
                if is_valid(current):
                    result.add(current)
                return

            if index == len(current):
                return

            for i in range(index, len(current)):
                # Skip duplicate parentheses
                if i > index and current[i] == current[i - 1]:
                    continue

                # Only parentheses can be removed
                if current[i] not in "()":
                    continue

                new_string = current[:i] + current[i + 1:]

                backtrack(i, new_string, removals - 1)

        # Find minimum number of removals
        left = 0
        right = 0

        for ch in s:
            if ch == '(':
                left += 1
            elif ch == ')':
                if left > 0:
                    left -= 1
                else:
                    right += 1

        removals = left + right

        backtrack(0, s, removals)

        return list(result)