package AbstractFactory;

public class OptionB implements CreateText {
    @Override
    public void create() {
        String text = """
                
                            _  (`-')(`-')      _                <-. (`-')_     <-.(`-') \s
                     .->    \\-.(OO )( OO).->  (_)         .->      \\( OO) )     __( OO) \s
                (`-')----.  _.'    \\/    '._  ,-(`-')(`-')----. ,--./ ,--/     '-'---.\\ \s
                ( OO).-.  '(_...--''|'--...__)| ( OO)( OO).-.  '|   \\ |  |     | .-. (/ \s
                ( _) | |  ||  |_.' |`--.  .--'|  |  )( _) | |  ||  . '|  |)    | '-' `.)\s
                 \\|  |)|  ||  .___.'   |  |  (|  |_/  \\|  |)|  ||  |\\    |     | /`'.  |\s
                  '  '-'  '|  |        |  |   |  |'->  '  '-'  '|  | \\   |     | '--'  /\s
                   `-----' `--'        `--'   `--'      `-----' `--'  `--'     `------' \s
                
                """;
        System.out.println(text + "1: Insert Coin \n 2: Press start");
    }
}
