package kisok;

public enum Location {
    MORRIS("07960","Morristown"),
    MIDDLESEX("08852","Piscataway"),
    SOMMERSET("08807","Bridgewater"),
    UNION("07083","Union"),
    MERCER("08542","Princeton");
    public final String zip;
    public final String cites;
    private Location(String zipcode,String cites){
        this.zip = zipcode;
        this.cites = cites;
    }
}
