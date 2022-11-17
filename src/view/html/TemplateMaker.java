
package view.html;

import static j2html.TagCreator.attrs;
import static j2html.TagCreator.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import model.Template;
import model.TemplateDrug;

/**
 *
 * @author 
 * 
 * Md. Tariqul Islam - 191002037
 * Omit Kumar        - 191002120
 * Joy Kumar Majumder- 191002121
 * Sonia Akter Mona  - 191002197
 * Abdur Razzak      - 191002206
 * 
 */

public class TemplateMaker {
    
    

    public String makeTemplate(Template template, ObservableList<TemplateDrug> drugs) {
        
        String string = html(
                head(
                        title("Template")
                ),
                body(
                        div(
                                p(
                                        b("Chief Complain"),
                                        br(),
                                        span(template.getCc())
                                ),
                                p(
                                        b("On Examination"),
                                        br(),
                                        span(template.getOe())
                                ),
                                p(
                                        b("Provisional Diagnosis"),
                                        br(),
                                        span(template.getDd())
                                ),
                                 p(
                                        b("Lab workup"),
                                        br(),
                                        span(template.getLab_workup())
                                ),
                                  p(
                                        b("Prescription Advice"),
                                        br(),
                                        span(template.getAdvice())
                                )
                        ).withStyle("display:inline;float:left;width:40%;"),
                        div(
                                h1("Rx"),
                                ol(
                                        each(drugs, drug -> tr(
                                        li(i(drug.getType() + " "), b(" " + drug.getDrug_name()), span(" " + drug.getStrength() + " "), ul(
                                                li(drug.getDose() + " " +drug.getDuration()).withStyle("list-style: none"),
                                                li(drug.getAdvice()).withStyle("list-style: none")
                                        ).withStyle("padding-left: 10px"))
                                ))
                                )
                        ).withStyle("display:inline;float:left;width:60%;")
                )
        ).render();

        return string;
    }

}
