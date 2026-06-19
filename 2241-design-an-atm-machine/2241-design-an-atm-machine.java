class ATM {

    long[] notes;
    int[] value;

    public ATM() {

        notes = new long[5];

        value =
            new int[]{20,50,100,200,500};
    }

    public void deposit(int[] banknotesCount) {

        for (int i = 0; i < 5; i++) {

            notes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {

        long[] used = new long[5];

        int remaining = amount;

        for (int i = 4; i >= 0; i--) {

            long take =
                Math.min(
                    notes[i],
                    remaining / value[i]
                );

            used[i] = take;

            remaining -=
                    take * value[i];
        }

        if (remaining != 0) {

            return new int[]{-1};
        }

        for (int i = 0; i < 5; i++) {

            notes[i] -= used[i];
        }

        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {

            result[i] = (int) used[i];
        }

        return result;
    }
}