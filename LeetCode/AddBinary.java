class AddBinary{

    public static void main(String args[]){
        String s1 = "10";
        String s2 = "110";
        AddBinary obj = new AddBinary();
        System.out.println("Final ans: "+obj.addBinary(s1, s2));
    }

    public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int diff = Math.abs(l1-l2);
        if(diff != 0){
            if(l1 < l2)
                a = pad(a, diff);
            else
                b = pad(b, diff);
        }
        return addHelper(a, b);
    }
    
    public String pad(String s, int diff){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<diff; i++){
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }
    
    public String addHelper(String s1, String s2){
        int n = s1.length();
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = n-1; i>=0; i--){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            int sum = (c1 - '0') + (c2 - '0') + carry;
            
            carry = sum/2;            
            ans.insert(0, sum%2);
        }
        if(carry == 1)
            ans.insert(0, carry);
        return ans.toString();
    }
}