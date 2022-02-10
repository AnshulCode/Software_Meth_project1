package kisok;

/**
 * The enum Location.
 */
//  presets for Location zip and city
public enum Location {
    /**
     * Morris location.
     */
    MORRIS("07960","Morristown","MORRIS"),
    /**
     * Middlesex location.
     */
    MIDDLESEX("08854","Piscataway","MIDDLESEX"),
    /**
     * Somerset location.
     */
    SOMERSET("08807","Bridgewater","SOMERSET"),
    /**
     * Union location.
     */
    UNION("07083","Union","UNION"),
    /**
     * Mercer location.
     */
    MERCER("08542","Princeton", "MERCER");

    /**
     * The Zip.
     */
    public final String zip;
    /**
     * The Cites.
     */
    public final String cites;
    /**
     * The County.
     */
    public final String county;

    private Location(String zipcode,String cites,String county){
        this.zip = zipcode;
        this.cites = cites;
        this.county = county;
    }


}
