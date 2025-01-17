package pro.dkart.bumbu.completion.stub;

import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.Processor;
import com.jetbrains.php.codeInsight.PhpScope;
import com.jetbrains.php.codeInsight.controlFlow.PhpControlFlow;
import com.jetbrains.php.lang.documentation.phpdoc.psi.PhpDocComment;
import com.jetbrains.php.lang.psi.elements.*;
import com.jetbrains.php.lang.psi.resolve.types.PhpType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;
import java.util.Set;

public class MethodStub {

    public Method createMethod(PhpClass phpClass) {

        return new Method() {
            private String name;

            @Override
            public <T> @Nullable T getUserData(@NotNull Key<T> key) {
                return null;
            }

            @Override
            public <T> void putUserData(@NotNull Key<T> key, @Nullable T value) {

            }

            @Override
            public Icon getIcon(int flags) {
                return AllIcons.Hierarchy.Class;
            }

            @Override
            public @NotNull Project getProject() throws PsiInvalidElementAccessException {
                return null;
            }

            @Override
            public @NotNull Language getLanguage() {
                return null;
            }

            @Override
            public PsiManager getManager() {
                return null;
            }

            @Override
            public @NotNull PsiElement @NotNull [] getChildren() {
                return new PsiElement[0];
            }

            @Override
            public PsiElement getParent() {
                return null;
            }

            @Override
            public PsiElement getFirstChild() {
                return null;
            }

            @Override
            public PsiElement getLastChild() {
                return null;
            }

            @Override
            public PsiElement getNextSibling() {
                return null;
            }

            @Override
            public PsiElement getPrevSibling() {
                return null;
            }

            @Override
            public PsiFile getContainingFile() throws PsiInvalidElementAccessException {
                return null;
            }

            @Override
            public TextRange getTextRange() {
                return null;
            }

            @Override
            public int getStartOffsetInParent() {
                return 0;
            }

            @Override
            public int getTextLength() {
                return 0;
            }

            @Override
            public @Nullable PsiElement findElementAt(int offset) {
                return null;
            }

            @Override
            public @Nullable PsiReference findReferenceAt(int offset) {
                return null;
            }

            @Override
            public int getTextOffset() {
                return 0;
            }

            @Override
            public @NlsSafe String getText() {
                return null;
            }

            @Override
            public char @NotNull [] textToCharArray() {
                return new char[0];
            }

            @Override
            public PsiElement getNavigationElement() {
                return null;
            }

            @Override
            public PsiElement getOriginalElement() {
                return null;
            }

            @Override
            public boolean textMatches(@NotNull @NonNls CharSequence text) {
                return false;
            }

            @Override
            public boolean textMatches(@NotNull PsiElement element) {
                return false;
            }

            @Override
            public boolean textContains(char c) {
                return false;
            }

            @Override
            public void accept(@NotNull PsiElementVisitor visitor) {

            }

            @Override
            public void acceptChildren(@NotNull PsiElementVisitor visitor) {

            }

            @Override
            public PsiElement copy() {
                return null;
            }

            @Override
            public PsiElement add(@NotNull PsiElement element) throws IncorrectOperationException {
                return null;
            }

            @Override
            public PsiElement addBefore(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException {
                return null;
            }

            @Override
            public PsiElement addAfter(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException {
                return null;
            }

            @Override
            public void checkAdd(@NotNull PsiElement element) throws IncorrectOperationException {

            }

            @Override
            public PsiElement addRange(PsiElement first, PsiElement last) throws IncorrectOperationException {
                return null;
            }

            @Override
            public PsiElement addRangeBefore(@NotNull PsiElement first, @NotNull PsiElement last, PsiElement anchor) throws IncorrectOperationException {
                return null;
            }

            @Override
            public PsiElement addRangeAfter(PsiElement first, PsiElement last, PsiElement anchor) throws IncorrectOperationException {
                return null;
            }

            @Override
            public void delete() throws IncorrectOperationException {

            }

            @Override
            public void checkDelete() throws IncorrectOperationException {

            }

            @Override
            public void deleteChildRange(PsiElement first, PsiElement last) throws IncorrectOperationException {

            }

            @Override
            public PsiElement replace(@NotNull PsiElement newElement) throws IncorrectOperationException {
                return null;
            }

            @Override
            public boolean isValid() {
                return false;
            }

            @Override
            public boolean isWritable() {
                return false;
            }

            @Override
            public @Nullable PsiReference getReference() {
                return null;
            }

            @Override
            public PsiReference @NotNull [] getReferences() {
                return new PsiReference[0];
            }

            @Override
            public <T> @Nullable T getCopyableUserData(@NotNull Key<T> key) {
                return null;
            }

            @Override
            public <T> void putCopyableUserData(@NotNull Key<T> key, @Nullable T value) {

            }

            @Override
            public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, @Nullable PsiElement lastParent, @NotNull PsiElement place) {
                return false;
            }

            @Override
            public @Nullable PsiElement getContext() {
                return null;
            }

            @Override
            public boolean isPhysical() {
                return false;
            }

            @Override
            public @NotNull GlobalSearchScope getResolveScope() {
                return null;
            }

            @Override
            public @NotNull SearchScope getUseScope() {
                return null;
            }

            @Override
            public ASTNode getNode() {
                return null;
            }

            @Override
            public @NonNls String toString() {
                return null;
            }

            @Override
            public boolean isEquivalentTo(PsiElement another) {
                return false;
            }

            @Override
            public @Nullable PhpPsiElement getFirstPsiChild() {
                return null;
            }

            @Override
            public @Nullable PhpPsiElement getNextPsiSibling() {
                return null;
            }

            @Override
            public @Nullable PhpPsiElement getPrevPsiSibling() {
                return null;
            }

            @Override
            public @NotNull PhpType getType() {
                return phpClass.getType();
            }

            @Override
            public @Nullable PhpReturnType getTypeDeclaration() {
                return null;
            }

            @Override
            public @Nullable PsiElement getNameIdentifier() {
                return null;
            }

            @Override
            public void navigate(boolean requestFocus) {

            }

            @Override
            public boolean canNavigate() {
                return false;
            }

            @Override
            public boolean canNavigateToSource() {
                return false;
            }

            @Override
            public @Nullable ASTNode getNameNode() {
                return null;
            }

            @Override
            public @NotNull @NlsSafe String getName() {
                return this.name;
            }

            @Override
            public PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException {
                this.name = name;

                return null;
            }

            @Override
            public @Nullable ItemPresentation getPresentation() {
                return null;
            }

            @Override
            public @NotNull @NlsSafe CharSequence getNameCS() {
                return null;
            }

            @Override
            public @Nullable PhpDocComment getDocComment() {
                return null;
            }

            @Override
            public void processDocs(Processor<PhpDocComment> processor) {

            }

            @Override
            public Icon getIcon() {
                return AllIcons.Hierarchy.MethodDefined;
            }

            @Override
            public @NotNull @NlsSafe String getFQN() {
                return null;
            }

            @Override
            public @NotNull @NlsSafe String getNamespaceName() {
                return null;
            }

            @Override
            public boolean isDeprecated() {
                return false;
            }

            @Override
            public boolean isInternal() {
                return false;
            }

            @Override
            public @NotNull PhpModifier getModifier() {
                return null;
            }

            @Override
            public @Nullable PhpClass getContainingClass() {
                return phpClass;
            }

            @Override
            public @NotNull Collection<@NotNull PhpAttribute> getAttributes() {
                return null;
            }

            @Override
            public @NotNull PhpControlFlow getControlFlow() {
                return null;
            }

            @Override
            public @NotNull Set<CharSequence> getPredefinedVariables() {
                return null;
            }

            @Override
            public @NotNull PhpScope getScope() {
                return null;
            }

            @Override
            public Parameter @NotNull [] getParameters() {
                return new Parameter[0];
            }

            @Override
            public @Nullable Parameter getParameter(int i) {
                return null;
            }

            @Override
            public boolean hasRefParams() {
                return false;
            }

            @Override
            public boolean isClosure() {
                return false;
            }

            @Override
            public @NotNull PhpType getLocalType(boolean b) {
                return null;
            }

            @Override
            public @Nullable PhpReturnType getReturnType() {
                return null;
            }

            @Override
            public Collection<String> getDocExceptions() {
                return null;
            }

            @Override
            public @Nullable MethodType getMethodType(boolean b) {
                return null;
            }

            @Override
            public boolean isStatic() {
                return false;
            }

            @Override
            public boolean isFinal() {
                return false;
            }

            @Override
            public boolean isAbstract() {
                return false;
            }

            @Override
            public PhpModifier.Access getAccess() {
                return null;
            }
        };
    }
}
