/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Guinness
 */
public class JCustomTextField extends JTextField {
    // <Variable Declaration>

    private static final long serialVersionUID = 1L;
    private String regex;
    private String[] simpleWords; // Stores unfiltered string in array form

    private boolean isFilteringEnabled = false;
    private boolean limitChars = false;
    private boolean limitWords = false;
    private boolean autoCapitalize = false;
    private boolean constCapitalize = false; // Since autoCapitalize goes false
    // as soon as first char is
    // entered, we need a reference
    // if user decides to erase and
    // re-enter first char
    private boolean isTextErasable = true;
    private boolean startupWhiteSpace = true;
    private boolean isMultiSpacingAllowed = true;
    private boolean playDingSound = false;

    private int maxLength; // Maximum allowed string length (if specified)
    private int maxWords; // Maximum allowed number of words (if specified)

    private AbstractDocument doc;

    private UndoableEditListener undoListener;

    private UndoManager undo = new UndoManager();

    // <Class extension methods>
    /**
     * <b>setCustomPattern</b><br>
     * Allows setting of custom <code>Pattern</code> to match or verify the
     * entered data. Read more about <a href=
     * "http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html">
     * Regex Patterns</a>.
     *
     * @param pattern
     */
    public void setCustomPattern(String pattern) {
        regex = pattern;
        isFilteringEnabled = true;
    }

    /**
     * <b>allowOnlyNumbers</b><br>
     * Allows only <b>numbers</b> to be entered in field.<br>
     * <br>
     * True as parameter means whitespaces are allowed.
     *
     * @param boolean
     */
    public void allowOnlyNumbers(boolean isWhiteSpaceAllowed) {
        if (isWhiteSpaceAllowed) {
            regex = "^$|[0-9\\W]*$";
        } else {
            regex = "^$|[0-9]*$";
        }
        isFilteringEnabled = true;
    }

    /**
     * <b>allowOnlyUppercase</b><br>
     * Allows only <b>Uppercase alphabets</b> to be entered in field.<br>
     * <br>
     * True as parameter means whitespaces are allowed.
     *
     * @param boolean
     */
    public void allowOnlyUppercase(boolean isWhiteSpaceAllowed) {
        if (isWhiteSpaceAllowed) {
            regex = "^$|[A-Z\\W]*$";
        } else {
            regex = "^$|[A-Z]*$";
        }
        isFilteringEnabled = true;
    }

    /**
     * <b>allowOnlyLowercase</b><br>
     * Allows only <b>Lowercase alphabets</b> to be entered in field.<br>
     * <br>
     * True as parameter means whitespaces are allowed.
     *
     * @param boolean
     */
    public void allowOnlyLowercase(boolean isWhiteSpaceAllowed) {
        if (isWhiteSpaceAllowed) {
            regex = "^$|[a-z\\W]*$";
        } else {
            regex = "^$|[a-z]*$";
        }
        isFilteringEnabled = true;
    }

    /**
     * <b>allowOnlyAlphabets</b><br>
     * Allows only <b>alphabets</b> to be entered in field.<br>
     * Case is not regarded.<br>
     * <br>
     * True as parameter means whitespaces are allowed.
     *
     * @param boolean
     */
    public void allowOnlyAlphabets(boolean isWhiteSpaceAllowed) {
        if (isWhiteSpaceAllowed) {
            regex = "^$|[A-Za-z\\W]*$";
        } else {
            regex = "^$|[A-Za-z]*$";
        }
        isFilteringEnabled = true;
    }

    /**
     * <b>allowNoSymbols</b><br>
     * Allows only <b>alphabets and numbers</b> to be entered in field<br>
     * Case is not regarded. <br>
     * <br>
     * True as parameter means whitespaces are allowed.
     *
     * @param boolean
     */
    public void allowNoSymbols(boolean isWhiteSpaceAllowed) {
        if (isWhiteSpaceAllowed) {
            regex = "^$|[0-9A-Za-z\\W]*$";
        } else {
            regex = "^$|[0-9A-Za-z]*$";
        }
        isFilteringEnabled = true;
    }

    /**
     * <b>allowNoSpacesAtStarting</b><br>
     * Prevents entering of spaces at starting of text. By default they are
     * <b>enabled</b>.
     */
    public void allowNoSpacesAtStarting() {
        startupWhiteSpace = false;
    }

    /**
     * <b>allowSpacesAtStarting</b><br>
     * Allows entering of spaces at starting of text. By default they are
     * <b>enabled</b> so this isn't required unless
     * <b>allowNoSpacesAtStarting()</b> is used.
     */
    public void allowSpacesAtStarting() {
        startupWhiteSpace = true;
    }

    /**
     * <b>allowOnlyStandardChars</b><br>
     * Allows only <b>alphabets</b> (case regardless), numbers and "<b>-</b>"
     * and "<b>_</b>" to be entered.
     */
    public void allowOnlyStandardChars() {
        regex = "^$|[0-9A-za-Z_-]*$";
        isFilteringEnabled = true;
    }

    /**
     * <b>disallowErasingText</b><br>
     * Will prevent text entered in field from being erased.
     */
    public void disallowErasingText() {
        isTextErasable = false;
    }

    /**
     * <b>allowErasingText</b><br>
     * Will allow text entered in field to be erased. <br>
     * This is enabled by default so should only be used if
     * <b>disallowErasingText</b> has been used before.
     */
    public void allowErasingText() {
        isTextErasable = true;
    }

    /**
     * <b>disableFilters</b><br>
     * Can be used to disable any filters. Text will be entered normally.<br>
     * Properties like <i>Word Limit</i>, <i>Char Limit</i> and
     * <i>autoCapitalization</i> still work.
     */
    public void disableFilters() {
        isFilteringEnabled = false;
    }

    /**
     * <b>enableFilters</b><br>
     * Can be used to re-enable filters.<br>
     * Should only be used if <b>disableFilters()</b> has been used since
     * filters are enabled by default.
     */
    public void enableFilters() {
        isFilteringEnabled = true;
    }

    /**
     * <b>getCurrentFilter</b><br>
     * Returns current <a href=
     * "http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html">
     * Regex</a> expression being used.<br>
     * <br>
     * <b>Return Type:</b> String
     */
    public String getCurrentFilter() {
        return regex;
    }

    /**
     * <b>setCharLimit</b><br>
     * Will prevent entering of characters if string length reaches more than
     * specified limit.
     *
     * @param limit
     */
    public void setCharLimit(int limit) {
        maxLength = limit;
        limitChars = true;
    }

    /**
     * <b>removeCharLimit<b><br>
     * Can be used to remove char limit real-time if one was specified. <br>
     * Please check function <b>setCharLimit</b>.
     */
    public void removeCharLimit() {
        limitChars = false;
    }

    /**
     * <b>getCharLimit</b><br>
     * Returns maximum allowed string length if specified or returns -1 if not
     * specified. Check method <b>setCharLimit</b>.<br>
     * <br>
     * <b>Return Type:</b> boolean
     */
    public int getCharLimit() {
        if (!limitChars) {
            return -1;
        }
        return maxLength;
    }

    /**
     * <b>getWordCount</b><br>
     * Returns Word Count of string entered in field.<br>
     * <br>
     * <b>Return Type:</b> Integer
     */
    public int getWordCount() {
        if (super.getText().isEmpty()) {
            return 0;
        } else if (isMultiSpacingAllowed) {
            return super.getText().trim().split("\\W").length;
        } else {
            return super.getText().trim().split("\\W").length;
        }
    }

    /**
     * <b>setWordLimit</b><br>
     * Will prevent entering of new words if number of words in string reaches
     * more than specified limit.
     *
     * @param limit
     */
    public void setWordLimit(int limit) {
        maxWords = limit;
        limitWords = true;
    }

    /**
     * <b>removeWordLimit<b><br>
     * Can be used to remove word limit real-time if one was specified. <br>
     * Please check function <b>setWordLimit</b>
     */
    public void removeWordLimit() {
        limitWords = false;
    }

    /**
     * <b>getWordLimit</b><br>
     * Returns maximum words allowed to be entered if specified or returns -1 if
     * not specified. Check method <b>setWordLimit</b>.<br>
     * <br>
     * <b>Return Type:</b> boolean
     */
    public int getWordLimit() {
        if (!limitWords) {
            return -1;
        }
        return maxWords;
    }

    /**
     * <b>autoCapitalizeFirstCharacter</b><br>
     * Will automatically set first character entered in field to UpperCase.
     */
    public void autoCapitalizeFirstCharacter() {
        autoCapitalize = true;
        constCapitalize = true;
    }

    /**
     * <b>disableCapitalizeFirstCharacter</b><br>
     * Will disable automatically setting first character in field to UpperCase.
     * <br>
     * This is the case by default so this should only be used if
     * <b>autoCapitalizeFirstCharacter</b> is used before.
     */
    public void disableAutoCapitalizeFirstCharacter() {
        autoCapitalize = false;
        constCapitalize = false;
    }

    /**
     * <b>allowMultiSpacing</b><br>
     * Will allow multi spacing in text field. This is enabled by default so it
     * should only be used if <b>disallowMultiSpacing</b> has been used. <br>
     */
    public void allowMultiSpacing() {
        isMultiSpacingAllowed = true;
    }

    /**
     * <b>disallowMultiSpacing</b><br>
     * Will disable multi spacing in text field.
     */
    public void disallowMultiSpacing() {
        isMultiSpacingAllowed = false;
    }

    /**
     * <b>verifyForEmailAddress</b><br>
     * Returns <b>True</b> if entered String matches email address pattern and
     * <b>False</b> if it doesn't. <br>
     * Expression check is in compliance with RFC 822 pattern for Email
     * verification. <br>
     * <b>Return Type:</b> boolean
     */
    public boolean verifyForEmailAddress() {
        // RFC 822 compliant expression check for email validation
        // Credits to ejboy on StackOverflow for java adoption of RFC 822 regex
        // (http://stackoverflow.com/questions/8204680/java-regex-email)
        regex = "(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)";
        if (super.getText().matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * <b>verifyForWebsite</b><br>
     * Returns <b>True</b> if entered String matches Website pattern and
     * <b>False</b> if it doesn't. <br>
     * <br>
     * <b>Return Type:</b> boolean
     */
    public boolean verifyForWebsite() {
        // Credits to TomC on StackOverflow
        // (http://stackoverflow.com/questions/163360/regular-expression-to-match-urls-in-java)
        regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (super.getText().matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * <b>verifyForPalindrome</b><br>
     * Returns <b>True</b> if entered String is <i>palindrome</i> and
     * <b>False</b> if it isn't. <br>
     * <br>
     * <b>Return Type:</b> boolean
     */
    public boolean verfiyForPalindrome(boolean ignoreCase) {
        String x;
        if (ignoreCase) {
            x = super.getText().toLowerCase();
        } else {
            x = super.getText();
        }
        int y = x.length();
        for (int i = 0; i < (y / 2) + 1; i++) {
            if (x.charAt(i) != x.charAt(y - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <b>enableUndoRedo</b><br>
     * Enables Undo and Redo operations on text field. <br>
     * <br>
     * Parameter is the number of edits to store for undo/redo operation <br>
     *
     * @param Integer
     */
    public void enableUndoRedo(int undoCount) {
        undoListener = new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent ev) {
                undo.addEdit(ev.getEdit());
            }
        };
        doc.addUndoableEditListener(undoListener);
    }

    /**
     * <b>disableUndoRedo</b><br>
     * Disables Undo and Redo operations on text field. <br>
     * <br>
     * Should only be used if <b>enabledUndoRedo()</b> has been used since its
     * off by default.
     */
    public void disableUndoRedo() {
        doc.removeUndoableEditListener(undoListener);
    }

    /**
     * <b>undo</b><br>
     * Will undo last edit. <br>
     * Works only if Undo/Redo is enabled first.<br>
     * Check function <b>enableUndoRedo</b>.
     */
    public void undo() throws CannotUndoException {
        undo.undo();
    }

    /**
     * <b>redo</b><br>
     * Will redo last undo. <br>
     * Works only if Undo/Redo is enabled first.<br>
     * Check function <b>enableUndoRedo</b>.
     */
    public void redo() throws CannotRedoException {
        undo.redo();
    }

    /**
     * <b>geUndoManager</b><br>
     * Returns default undo manager. <br>
     * Works only if Undo/Redo is enabled first.<br>
     * Check function <b>enableUndoRedo</b>.
     *
     * @return UndoManager
     */
    public UndoManager getUndoManager() {
        return undo;
    }

    /**
     * <b>getCharCount</b><br>
     * Returns character count in entered string<br>
     *
     * @return int
     */
    public int getCharCount() {
        return super.getText().length() + 1;
    }

    /**
     * <b>reverse</b><br>
     * Returns reversed string of text in field<br>
     *
     * @return String
     */
    public String reverse() {
        String text = super.getText();
        int len = text.length();
        StringBuilder rev = new StringBuilder();
        for (int i = (len - 1); i >= 0; i--) {
            rev.append(text.charAt(i));
        }

        return rev.toString();
    }

    /**
     * <b>playDingSounds</b><br>
     * Play "Ding" sound everytime an invalid char is entered. <br>
     * <br>
     * "true" means it will play. By default it is "false".
     */
    public void playDingSounds() {
        playDingSound = true;
        dingPlayer();
    }

    /**
     * <b>disableDingSounds</b><br>
     * Disables "Ding" sounds on entering invalid char<br>
     * <br>
     * This is disabled by default so should not be used unless ding sounds are
     * enabled. Check method <b>playDingSounds</b>
     */
    public void disableDingSounds() {
        playDingSound = false;
    }

    // <Internal Methods>
    // This splits the string by spaces and returns the length after splitting
    private int internalWordCount(String text) {
        if (isMultiSpacingAllowed) {
            simpleWords = text.trim().split("\\W");
        } else {
            simpleWords = text.trim().split("\\W+");
        }
        return simpleWords.length;
    }

    // Checks if the previous char was Space or Tab
    private boolean checkForSpace() {
        if (super.getText().length() > 0
                && super.getText().substring((super.getText().length() - 1), super.getText().length()).matches("\\W")) {
            return true;
        }
        return false;
    }

    private void dingPlayer() {
        if (playDingSound) {
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }

    // For internal use
    public String getText() {
        return super.getText();
    }

    public void setText(String text) {
        super.setText(text);
    }

    // Main method
    public JCustomTextField() {
        // We use Document Filter to filter the string
        doc = (AbstractDocument) super.getDocument();
        super.setDocument(doc);
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {

                // Check if auto Capitalization is on
                if (offset == 0 && constCapitalize) {
                    autoCapitalize = true;
                }

                // Case 1: Word limit is present---------------------
                // Check if a word limit is specified and filter/trim words
                // accordingly
                if (limitWords && internalWordCount(string) > maxWords) {
                    // Check if white space at start of string is allowed, if
                    // not then remove it
                    if (!startupWhiteSpace && string.startsWith("[\\W+]")) {
                        string.replaceFirst("[\\w+]", "");
                        dingPlayer();
                    }
                    // Empty out existing string to set new string with filters
                    string = "";

                    // String trimming and filtering
                    for (int i = 0, counter = maxWords; i < counter; i++) // Check if filtering is enabled or any filters are
                    // specified
                    {
                        if (isFilteringEnabled) {
                            if (simpleWords[i].matches(regex)) {
                                // If the element in array matches filter, add
                                // to string
                                string += simpleWords[i] + " ";
                                // If element is space, increase the loop limit
                                // since multi-space doesn't count as word
                                if (simpleWords[i].matches("^$")) {
                                    counter++;
                                }
                            } // If current word didn't match pattern, move on to
                            // next word and iterate the loop accordingly
                            else {
                                counter++;
                                dingPlayer();
                            }
                        } else {
                            string += simpleWords[i] + " ";
                        }
                    }
                    // Remove the one trailing space
                    string = string.substring(0, (string.length() - 1));
                } // Case 2: No word limit------------------------
                // Just check for filters
                else if (isFilteringEnabled) {
                    simpleWords = (isMultiSpacingAllowed) ? string.split("[\\W]") : string.split("\\W+");
                    string = "";

                    // Match array element with pattern and append
                    for (int i = 0; i < simpleWords.length; i++) {
                        if (simpleWords[i].matches(regex)) {
                            string += simpleWords[i] + " ";
                        } else {
                            dingPlayer();
                        }
                    }
                    string = string.substring(0, (string.length() - 1));

                    if (!startupWhiteSpace && string.substring(0, 1).matches("\\W+")) {
                        string = string.replaceFirst("\\W+", "");
                        dingPlayer();
                    }
                }

                // Trim to match maximum length if specified
                if (limitChars && string.length() > maxLength) {
                    string = string.substring(0, maxLength);
                    dingPlayer();
                }

                if (autoCapitalize) {
                    autoCapitalize = false;
                    string = string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase());
                }
                fb.insertString(offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {

                // Auto Capitalization check
                if (offset == 0 && constCapitalize) {
                    autoCapitalize = true;
                }

                // If text is manual typed and not a copy/paste
                // Code returns if:
                // Offset exceeds maximum length
                // Starting with whitespace
                // Exceeding max word count
                if (text.length() <= 1 && ((limitChars && offset == maxLength)
                        || (offset == 0 && text.matches("[\\W+]") && !startupWhiteSpace)
                        || (limitWords && offset > 0 && getWordCount() == maxWords && text.matches("[\\W+]"))
                        || (text.matches("\\W") && !isMultiSpacingAllowed && checkForSpace()))) {
                    dingPlayer();
                    return;
                } // Rare case at insertion when offset < maxLength and
                // string != null and char limit present
                else if (limitChars && getCharCount() > (maxLength)) {
                    dingPlayer();
                    return;
                }
                // Case 1: Copy/Pasted string
                // Difference occurs due to multichar (Copy/Pasted string)
                // vs single char
                if (text.length() > 1) {
                    if (limitWords && internalWordCount(text) > maxWords) {
                        text = ""; // Ready to accumulate new filtered string

                        // Preserve variable value for maxWords
                        for (int i = 0, counter = maxWords; i < counter; i++) {
                            if (isFilteringEnabled) {
                                if (simpleWords[i].matches(regex)) {
                                    text += simpleWords[i] + " ";
                                } else {
                                    // Move to next word if current doesn't
                                    // match
                                    counter++;
                                    dingPlayer();
                                }
                            } else {
                                text += simpleWords[i] + " ";
                            }
                        }
                        text = text.substring(0, (text.length() - 1));
                    }
                    // Trim text if length limit present and exceeded
                    if (limitChars && text.length() > maxLength) {
                        text = text.substring(0, maxLength);
                        dingPlayer();
                    }
                    if (autoCapitalize) {
                        autoCapitalize = false;
                        text = text.replace(text.substring(0, 1), text.substring(0, 1).toUpperCase());
                    }
                    fb.replace(offset, length, text.substring(0, (text.length() - 1)), attrs);
                } // Case 2: Manually entered char
                // Single char string value
                else if (isFilteringEnabled) {
                    if (text.matches(regex)) {
                        if (autoCapitalize) {
                            autoCapitalize = false;
                            text = text.toUpperCase();
                        }
                        fb.replace(offset, length, text, attrs);
                    } else {
                        dingPlayer();
                    }
                } // Case 3: Manually entered char and no filters enabled
                else if (!isFilteringEnabled) {
                    if (autoCapitalize) {
                        autoCapitalize = false;
                        text = text.toUpperCase();
                    }
                    fb.replace(offset, length, text, attrs);
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                if (isTextErasable) {
                    fb.remove(offset, length);

                    // Apply attributes to next char if first char in string was
                    // removed
                    if (offset == 0 && !getText().isEmpty()) {
                        if (getText().substring(0, 1).matches("\\W+") && !startupWhiteSpace) {
                            dingPlayer();
                            setText(getText().replaceFirst("\\W+", ""));
                        } else if (constCapitalize) {
                            fb.replace(0, 1, getText().substring(0, 1).toUpperCase(), null);
                        }
                    }
                } else {
                    dingPlayer();
                }
            }
        });
    }
}
