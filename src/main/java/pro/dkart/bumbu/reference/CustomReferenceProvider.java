package pro.dkart.bumbu.reference;

import com.intellij.model.Symbol;
import com.intellij.model.psi.ImplicitReferenceProvider;
import com.intellij.model.psi.PsiSymbolService;
import com.intellij.psi.PsiElement;
import com.jetbrains.php.PhpIndex;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import com.jetbrains.php.lang.psi.elements.impl.MethodReferenceImpl;
import com.jetbrains.php.lang.psi.elements.impl.VariableImpl;
import com.jetbrains.php.lang.psi.resolve.types.PhpType;
import org.jetbrains.annotations.NotNull;
import pro.dkart.bumbu.tool.BumbuTool;

import java.util.Collection;
import java.util.Collections;

public class CustomReferenceProvider implements ImplicitReferenceProvider {

    @Override
    public @NotNull Collection<? extends Symbol> resolveAsReference(@NotNull PsiElement element) {
        if (element instanceof MethodReferenceImpl methodReference) {
            PsiElement variable = methodReference.getClassReference();
            if (variable != null) {
                PhpType classType = ((VariableImpl) variable).getType();

                PhpIndex phpIndex = PhpIndex.getInstance(variable.getProject());

                for (String className : classType.getTypes()) {
                    Collection<PhpClass> classes = phpIndex.getClassesByFQN(className);
                    if (!classes.isEmpty()) {
                        PhpClass phpClass = classes.iterator().next();
                        if (phpClass != null) {
                            if (new BumbuTool().isBumbuMethod(phpClass, methodReference.getName())) {

                                PsiElement attribute = new BumbuTool().getBumbuAttibuteByMethod(phpClass, methodReference.getName());
                                PsiSymbolService psiSymbolService = PsiSymbolService.getInstance();
                                Symbol symbol = psiSymbolService.asSymbol(attribute);

                                return Collections.singleton(symbol);
                            }
                        }
                    }
                }
            }
        }
        return Collections.emptyList();
    }
}