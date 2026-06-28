class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        backtrack(result, s, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(
            List<String> result,
            String s,
            int index,
            List<String> parts) {

        if (parts.size() == 4) {

            if (index == s.length()) {

                result.add(
                    String.join(".", parts));
            }

            return;
        }

        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length())
                break;

            String part =
                s.substring(index, index + len);

            if ((part.startsWith("0")
                    && part.length() > 1)
                ||
                Integer.parseInt(part) > 255)
                continue;

            parts.add(part);

            backtrack(
                result,
                s,
                index + len,
                parts);

            parts.remove(parts.size() - 1);
        }
    }
}