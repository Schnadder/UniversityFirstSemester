    package Oving10;

    public class Arrangement {
        private int nummer;
        private String navn;
        private String sted;
        private String arrangør;
        private String type;
        private long tidspunkt;

        
        public Arrangement(int nummer, String navn, String sted, String arrangør, String type, long tidspunkt) {
            this.nummer = nummer;
            this.navn = navn;
            this.sted = sted;
            this.arrangør = arrangør;
            this.type = type;
            this.tidspunkt = tidspunkt;
        }

        public int getNummer() {
            return nummer;
        }

        public String getNavn() {
            return navn;
        }

        public String getSted() {
            return sted;
        }

        public String getArrangør() {
            return arrangør;
        }

        public String getType() {
            return type;
        }

        public long getTidspunkt() {
            return tidspunkt;
        }

        public String strTidspunkt(){
            String tidspunktStr = String.valueOf(tidspunkt);
            if (tidspunktStr.length() != 12) {
                throw new IllegalArgumentException("Ugyldig tidspunktformat");
            }
        
            String år = tidspunktStr.substring(0, 4);
            String måned = tidspunktStr.substring(4, 6);
            String dag = tidspunktStr.substring(6, 8);
            String time = tidspunktStr.substring(8, 10);
            String minutt = tidspunktStr.substring(10, 12);
        
            return år + "." + måned + "." + dag + "." + time + ":" + minutt;
        }


        @Override
        public String toString() {
            return String.format("Arrangement nummer: %d   Navn: %s   Sted: %s   Arrangør: %s   Type: %s   Tidspunkt: %s",
                    nummer, navn, sted, arrangør, type, this.strTidspunkt());
        }

        
        
    }
