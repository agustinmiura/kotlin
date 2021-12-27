package ar.com.miura.jvm.string;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        java.util.Set<String> addresses = new java.util.HashSet<String>();
        int size = emails.length;
        for(int i=0;i<size;i++) {
            String email = emails[i];
            email = filter(email);
            addresses.add(email);
        }
        return addresses.size();
    }

    private String filter(String email) {

        String[] splitted = email.split("@");

        String localName = splitted[0];
        String domain = splitted[1];

        int atIndex = localName.indexOf('+');
        if (atIndex>=0) {
            localName = localName.substring(0, atIndex);
        }
        localName = localName.replace(".","");

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(localName);
        sBuilder.append("@");
        sBuilder.append(domain);

        return sBuilder.toString();

    }
}
