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
import com.jetbrains.php.lang.PhpLanguage;
import com.jetbrains.php.lang.documentation.phpdoc.psi.PhpDocComment;
import com.jetbrains.php.lang.psi.elements.*;
import com.jetbrains.php.lang.psi.resolve.types.PhpType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class MethodStub {

    public Method createMethod(PhpClass phpClass, String name) {
        return new Method() {
            @Override
            public @NotNull PhpType getType() {
                return phpClass.getType();
            }

            @Override
            public @NotNull PhpModifier getModifier() {
                return null;
            }

            @Override
            public @NotNull Collection<@NotNull PhpAttribute> getAttributes() {
                return Collections.emptyList();
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
                return PhpModifier.Access.PUBLIC;
            }

            @Override
            public <T> @Nullable T getUserData(@NotNull Key<T> key) {
                return null; // Нет данных
            }

            @Override
            public <T> void putUserData(@NotNull Key<T> key, @Nullable T value) {
                // Не сохраняем данные
            }

            @Override
            public Icon getIcon(int flags) {
                return AllIcons.Hierarchy.MethodDefined; // Иконка для метода
            }

            @Override
            public @NotNull Project getProject() throws PsiInvalidElementAccessException {
                return phpClass.getProject(); // Не используется
            }

            @Override
            public @NotNull Language getLanguage() {
                return PhpLanguage.INSTANCE;
            }

            @Override
            public PsiManager getManager() {
                return null; // Не используется
            }

            @Override
            public @NotNull PsiElement @NotNull [] getChildren() {
                return new PsiElement[0]; // Нет дочерних элементов
            }

            @Override
            public PsiElement getParent() {
                return null; // Нет родительского элемента
            }

            @Override
            public PsiElement getFirstChild() {
                return null; // Нет первого дочернего элемента
            }

            @Override
            public PsiElement getLastChild() {
                return null; // Нет последнего дочернего элемента
            }

            @Override
            public PsiElement getNextSibling() {
                return null; // Нет следующего элемента
            }

            @Override
            public PsiElement getPrevSibling() {
                return null; // Нет предыдущего элемента
            }

            @Override
            public PsiFile getContainingFile() throws PsiInvalidElementAccessException {
                return null; // Не используется
            }

            @Override
            public TextRange getTextRange() {
                return TextRange.EMPTY_RANGE; // Пустой диапазон
            }

            @Override
            public int getStartOffsetInParent() {
                return 0; // Начальный сдвиг в родительском элементе
            }

            @Override
            public int getTextLength() {
                return 0; // Длина текста
            }

            @Override
            public @Nullable PsiElement findElementAt(int offset) {
                return null; // Не используется
            }

            @Override
            public @Nullable PsiReference findReferenceAt(int offset) {
                return null; // Не используется
            }

            @Override
            public int getTextOffset() {
                return 0; // Смещение текста
            }

            @Override
            public @NlsSafe String getText() {
                return name; // Возвращаем имя метода
            }

            @Override
            public char @NotNull [] textToCharArray() {
                return name.toCharArray(); // Преобразуем в массив символов
            }

            @Override
            public PsiElement getNavigationElement() {
                return null; // Нет элемента навигации
            }

            @Override
            public PsiElement getOriginalElement() {
                return null; // Нет оригинального элемента
            }

            @Override
            public boolean textMatches(@NotNull @NonNls CharSequence text) {
                return name.equals(text); // Сравниваем с именем метода
            }

            @Override
            public boolean textMatches(@NotNull PsiElement element) {
                return false; // Не поддерживаем сравнение с другим элементом
            }

            @Override
            public boolean textContains(char c) {
                return name.indexOf(c) != -1; // Проверка на наличие символа
            }

            @Override
            public void accept(@NotNull PsiElementVisitor visitor) {
                // Не используется
            }

            @Override
            public void acceptChildren(@NotNull PsiElementVisitor visitor) {
                // Не используется
            }

            @Override
            public PsiElement copy() {
                return null; // Не требуется
            }

            @Override
            public PsiElement add(@NotNull PsiElement element) throws IncorrectOperationException {
                return null; // Не поддерживаем добавление
            }

            @Override
            public PsiElement addBefore(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException {
                return null; // Не поддерживаем добавление
            }

            @Override
            public PsiElement addAfter(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException {
                return null; // Не поддерживаем добавление
            }

            @Override
            public void checkAdd(@NotNull PsiElement element) throws IncorrectOperationException {
                // Не требуется
            }

            @Override
            public PsiElement addRange(PsiElement first, PsiElement last) throws IncorrectOperationException {
                return null; // Не поддерживаем добавление диапазона
            }

            @Override
            public PsiElement addRangeBefore(@NotNull PsiElement first, @NotNull PsiElement last, PsiElement anchor) throws IncorrectOperationException {
                return null; // Не поддерживаем добавление диапазона
            }

            @Override
            public PsiElement addRangeAfter(PsiElement first, PsiElement last, PsiElement anchor) throws IncorrectOperationException {
                return null; // Не поддерживаем добавление диапазона
            }

            @Override
            public void delete() throws IncorrectOperationException {
                // Не требуется
            }

            @Override
            public void checkDelete() throws IncorrectOperationException {
                // Не требуется
            }

            @Override
            public void deleteChildRange(PsiElement first, PsiElement last) throws IncorrectOperationException {
                // Не требуется
            }

            @Override
            public PsiElement replace(@NotNull PsiElement newElement) throws IncorrectOperationException {
                return null; // Не поддерживаем замену
            }

            @Override
            public boolean isValid() {
                return true; // Метод действителен
            }

            @Override
            public boolean isWritable() {
                return false; // Не поддерживаем запись
            }

            @Override
            public @Nullable PsiReference getReference() {
                return null; // Не используется
            }

            @Override
            public PsiReference @NotNull [] getReferences() {
                return new PsiReference[0]; // Нет ссылок
            }

            @Override
            public <T> @Nullable T getCopyableUserData(@NotNull Key<T> key) {
                return null; // Нет данных
            }

            @Override
            public <T> void putCopyableUserData(@NotNull Key<T> key, @Nullable T value) {
                // Не сохраняем данные
            }

            @Override
            public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, @Nullable PsiElement lastParent, @NotNull PsiElement place) {
                return false; // Не обрабатываем декларации
            }

            @Override
            public @Nullable PsiElement getContext() {
                return phpClass.getContext();
            }

            @Override
            public boolean isPhysical() {
                return true; // Метод физический
            }

            @Override
            public @NotNull GlobalSearchScope getResolveScope() {
                return GlobalSearchScope.allScope(getProject()); // Область разрешения
            }

            @Override
            public @NotNull SearchScope getUseScope() {
                return GlobalSearchScope.allScope(getProject()); // Область использования
            }

            @Override
            public ASTNode getNode() {
                return null; // Нет узла AST
            }

            @Override
            public @NonNls String toString() {
                return "MethodStub: " + getName(); // Возвращаем строковое представление
            }

            @Override
            public boolean isEquivalentTo(PsiElement another) {
                return false; // Не эквивалентен другим элементам
            }

            @Override
            public @Nullable PhpPsiElement getFirstPsiChild() {
                return null; // Нет первого дочернего элемента
            }

            @Override
            public @Nullable PhpPsiElement getNextPsiSibling() {
                return null; // Нет следующего соседа
            }

            @Override
            public @Nullable PhpPsiElement getPrevPsiSibling() {
                return null; // Нет предыдущего соседа
            }

            @Override
            public @Nullable PhpReturnType getTypeDeclaration() {
                return null; // Нет объявления типа
            }

            @Override
            public @Nullable PsiElement getNameIdentifier() {
                return null; // Нет идентификатора имени
            }

            @Override
            public void navigate(boolean requestFocus) {
                // Не поддерживаем навигацию
            }

            @Override
            public boolean canNavigate() {
                return false; // Не поддерживаем навигацию
            }

            @Override
            public boolean canNavigateToSource() {
                return false; // Не поддерживаем навигацию к источнику
            }

            @Override
            public @Nullable ItemPresentation getPresentation() {
                return null; // Нет представления
            }

            @Override
            public @Nullable ASTNode getNameNode() {
                return null;
            }

            @Override
            public @NotNull String getName() {
                return name; // Возвращаем имя метода
            }

            @Override
            public PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException {
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
                return null;
            }

            @Override
            public @NotNull @NlsSafe String getFQN() {
                return null;
            }

            @Override
            public @NotNull @NlsSafe String getNamespaceName() {
                return phpClass.getNamespaceName();  // Возвращаем пустую строку, если namespace не определен
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
            public PhpClass getContainingClass() {
                return phpClass; // Возвращаем класс
            }

            @Override
            public Parameter @NotNull [] getParameters() {
                return new Parameter[0]; // Нет параметров
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
                return phpClass.getType();
            }

            @Override
            public @Nullable PhpReturnType getReturnType() {
                return null;
            }

            @Override
            public Collection<String> getDocExceptions() {
                return null;
            }
        };
    }
}
