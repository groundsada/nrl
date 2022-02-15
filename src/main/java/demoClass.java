import net.sourceforge.nrl.parser.NRLParser;
import net.sourceforge.nrl.parser.INRLParser;
import net.sourceforge.nrl.parser.ast.IDeclaration;
import net.sourceforge.nrl.parser.ast.IRuleFile;
import net.sourceforge.nrl.parser.ast.action.IActionRuleDeclaration;
import net.sourceforge.nrl.parser.ast.constraints.IConstraintRuleDeclaration;
import java.io.FileReader;

public class demoClass {
	public static void main(String[] args) {
		INRLParser nrl_parser = new NRLParser();
		IRuleFile rf = null;
		for (int i = 1; i <= 3; i++) {
			System.out.println("\nFile: demo" + i + ".nrl:");
			try {
				rf = nrl_parser.parse(new FileReader("src/main/resources/demo" + i + ".nrl"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (IDeclaration rule_dec : rf.getDeclarations()) {
				if (rule_dec instanceof IConstraintRuleDeclaration) {
					System.out.println("Constraint rule " + rule_dec.getId());
				}
				else if (rule_dec instanceof IActionRuleDeclaration) {
					System.out.println("Action rule " + rule_dec.getId());
				}
			}
		}
	}
}