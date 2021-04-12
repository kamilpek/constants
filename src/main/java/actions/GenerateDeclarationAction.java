package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import modifieres.DeclarationGenerator;
import modifieres.RegularStrategy;
import org.jetbrains.annotations.NotNull;

public class GenerateDeclarationAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        DeclarationGenerator declarationGenerator = new DeclarationGenerator();
        declarationGenerator.modifyStringCase(new RegularStrategy(), e);
    }
}
