package kisok;

//  presets for Location zip and city
public enum Location {
    MORRIS("07960","Morristown","MORRIS"),
    MIDDLESEX("08854","Piscataway","MIDDLESEX"),
    SOMERSET("08807","Bridgewater","SOMERSET"),
    UNION("07083","Union","UNION"),
    MERCER("08542","Princeton", "MERCER");

    public final String zip;
    public final String cites;
    public final String county;

    private Location(String zipcode,String cites,String county){
        this.zip = zipcode;
        this.cites = cites;
        this.county = county;
    }


}
