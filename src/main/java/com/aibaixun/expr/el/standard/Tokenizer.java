package com.aibaixun.expr.el.standard;

import com.aibaixun.expr.ExprParserException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wang xiao
 * date 2022/10/20
 */
 class Tokenizer {

   private static final byte[] FLAGS = new byte[256];

 private static final String[] ALTERNATIVE_OPERATOR_NAMES = new String[]{"DIV", "EQ", "GE", "GT", "LE", "LT", "MOD", "NE", "NOT"};
   private final String expression;

   private char[] charsToProcess;

   private int pos;

   private final int max;

   private final List<Token> tokens = new ArrayList();

  public Tokenizer(String token) {
   this.expression = token;
   this.charsToProcess = token.toCharArray();
   this.max = token.length();
   this.pos = 0;
  }


  List<Token> process(){
   while(this.pos < this.max) {
    char ch = this.charsToProcess[this.pos];
    if (this.isAlphabetic(ch)) {
     this.lexIdentifier();
    } else {
     switch (ch) {
      case '\u0000':
       ++this.pos;
       break;
      case '\u0001':
      case '\u0002':
      case '\u0003':
      case '\u0004':
      case '\u0005':
      case '\u0006':
      case '\u0007':
      case '\b':
      case '\u000b':
      case '\f':
      case '\u000e':
      case '\u000f':
      case '\u0010':
      case '\u0011':
      case '\u0012':
      case '\u0013':
      case '\u0014':
      case '\u0015':
      case '\u0016':
      case '\u0017':
      case '\u0018':
      case '\u0019':
      case '\u001a':
      case '\u001b':
      case '\u001c':
      case '\u001d':
      case '\u001e':
      case '\u001f':
      case ';':
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
      case 'G':
      case 'H':
      case 'I':
      case 'J':
      case 'K':
      case 'L':
      case 'M':
      case 'N':
      case 'O':
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
      case 'T':
      case 'U':
      case 'V':
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
      case '`':
      case 'a':
      case 'b':
      case 'c':
      case 'd':
      case 'e':
      case 'f':
      case 'g':
      case 'h':
      case 'i':
      case 'j':
      case 'k':
      case 'l':
      case 'm':
      case 'n':
      case 'o':
      case 'p':
      case 'q':
      case 'r':
      case 's':
      case 't':
      case 'u':
      case 'v':
      case 'w':
      case 'x':
      case 'y':
      case 'z':
      default:
       throw new IllegalStateException("Cannot handle (" + ch + ") '" + ch + "'");
      case '\t':
      case '\n':
      case '\r':
      case ' ':
       ++this.pos;
       break;
      case '!':
       if (this.isTwoCharToken(TokenType.NE)) {
        this.pushPairToken(TokenType.NE);
       } else {
        if (this.isTwoCharToken(TokenType.PROJECT)) {
         this.pushPairToken(TokenType.PROJECT);
         continue;
        }

        this.pushCharToken(TokenType.NOT);
       }
       break;
      case '"':
       this.lexDoubleQuotedStringLiteral();
       break;
      case '#':
       this.pushCharToken(TokenType.HASH);
       break;
      case '$':
       if (this.isTwoCharToken(TokenType.SELECT_LAST)) {
        this.pushPairToken(TokenType.SELECT_LAST);
        break;
       }

       this.lexIdentifier();
       break;
      case '%':
       this.pushCharToken(TokenType.MOD);
       break;
      case '&':
       if (this.isTwoCharToken(TokenType.SYMBOLIC_AND)) {
        this.pushPairToken(TokenType.SYMBOLIC_AND);
        break;
       }

       this.pushCharToken(TokenType.FACTORY_BEAN_REF);
       break;
      case '\'':
       this.lexQuotedStringLiteral();
       break;
      case '(':
       this.pushCharToken(TokenType.LPAREN);
       break;
      case ')':
       this.pushCharToken(TokenType.RPAREN);
       break;
      case '*':
       this.pushCharToken(TokenType.STAR);
       break;
      case '+':
       if (this.isTwoCharToken(TokenType.INC)) {
        this.pushPairToken(TokenType.INC);
        break;
       }

       this.pushCharToken(TokenType.PLUS);
       break;
      case ',':
       this.pushCharToken(TokenType.COMMA);
       break;
      case '-':
       if (this.isTwoCharToken(TokenType.DEC)) {
        this.pushPairToken(TokenType.DEC);
        break;
       }

       this.pushCharToken(TokenType.MINUS);
       break;
      case '.':
       this.pushCharToken(TokenType.DOT);
       break;
      case '/':
       this.pushCharToken(TokenType.DIV);
       break;
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
       this.lexNumericLiteral(ch == '0');
       break;
      case ':':
       this.pushCharToken(TokenType.COLON);
       break;
      case '<':
       if (this.isTwoCharToken(TokenType.LE)) {
        this.pushPairToken(TokenType.LE);
        break;
       }

       this.pushCharToken(TokenType.LT);
       break;
      case '=':
       if (this.isTwoCharToken(TokenType.EQ)) {
        this.pushPairToken(TokenType.EQ);
        break;
       }

       this.pushCharToken(TokenType.ASSIGN);
       break;
      case '>':
       if (this.isTwoCharToken(TokenType.GE)) {
        this.pushPairToken(TokenType.GE);
        break;
       }

       this.pushCharToken(TokenType.GT);
       break;
      case '?':
       if (this.isTwoCharToken(TokenType.SELECT)) {
        this.pushPairToken(TokenType.SELECT);
       } else if (this.isTwoCharToken(TokenType.ELVIS)) {
        this.pushPairToken(TokenType.ELVIS);
       } else {
        if (this.isTwoCharToken(TokenType.SAFE_NAVI)) {
         this.pushPairToken(TokenType.SAFE_NAVI);
         continue;
        }

        this.pushCharToken(TokenType.QMARK);
       }
       break;
      case '@':
       this.pushCharToken(TokenType.BEAN_REF);
       break;
      case '[':
       this.pushCharToken(TokenType.LSQUARE);
       break;
      case '\\':
       this.raiseParseException(this.pos, "UNEXPECTED_ESCAPE_CHAR", String.valueOf(ch));
       break;
      case ']':
       this.pushCharToken(TokenType.RSQUARE);
       break;
      case '^':
       if (this.isTwoCharToken(TokenType.SELECT_FIRST)) {
        this.pushPairToken(TokenType.SELECT_FIRST);
        break;
       }

       this.pushCharToken(TokenType.POWER);
       break;
      case '_':
       this.lexIdentifier();
       break;
      case '{':
       this.pushCharToken(TokenType.LCURLY);
       break;
      case '|':
       if (!this.isTwoCharToken(TokenType.SYMBOLIC_OR)) {
        this.raiseParseException(this.pos, "MISSING_CHARACTER", "|");
       }

       this.pushPairToken(TokenType.SYMBOLIC_OR);
       break;
      case '}':
       this.pushCharToken(TokenType.RCURLY);
     }
    }
   }

   return this.tokens;
  }

 private void lexQuotedStringLiteral() {
  int start = this.pos;
  boolean terminated = false;

  while(!terminated) {
   ++this.pos;
   char ch = this.charsToProcess[this.pos];
   if (ch == '\'') {
    if (this.charsToProcess[this.pos + 1] == '\'') {
     ++this.pos;
    } else {
     terminated = true;
    }
   }

   if (this.isExhausted()) {
    this.raiseParseException(start, "NON_TERMINATING_QUOTED_STRING",null);
   }
  }

  ++this.pos;
  this.tokens.add(new Token(TokenType.LITERAL_STRING, this.subarray(start, this.pos), start, this.pos));
 }

 private void lexDoubleQuotedStringLiteral() {
  int start = this.pos;
  boolean terminated = false;

  while(!terminated) {
   ++this.pos;
   char ch = this.charsToProcess[this.pos];
   if (ch == '"') {
    if (this.charsToProcess[this.pos + 1] == '"') {
     ++this.pos;
    } else {
     terminated = true;
    }
   }

   if (this.isExhausted()) {
    this.raiseParseException(start, "NON_TERMINATING_DOUBLE_QUOTED_STRING", null);
   }
  }

  ++this.pos;
  this.tokens.add(new Token(TokenType.LITERAL_STRING, this.subarray(start, this.pos), start, this.pos));
 }

 private void lexNumericLiteral(boolean firstCharIsZero) {
  boolean isReal = false;
  int start = this.pos;
  char ch = this.charsToProcess[this.pos + 1];
  boolean isHex = ch == 'x' || ch == 'X';
  if (firstCharIsZero && isHex) {
   ++this.pos;

   do {
    ++this.pos;
   } while(this.isHexadecimalDigit(this.charsToProcess[this.pos]));

   if (this.isChar('L', 'l')) {
    this.pushHexIntToken(this.subarray(start + 2, this.pos), true, start, this.pos);
    ++this.pos;
   } else {
    this.pushHexIntToken(this.subarray(start + 2, this.pos), false, start, this.pos);
   }

  } else {
   do {
    ++this.pos;
   } while(this.isDigit(this.charsToProcess[this.pos]));

   ch = this.charsToProcess[this.pos];
   int endOfNumber;
   if (ch == '.') {
    isReal = true;
    endOfNumber = this.pos;

    do {
     ++this.pos;
    } while(this.isDigit(this.charsToProcess[this.pos]));

    if (this.pos == endOfNumber + 1) {
     this.pos = endOfNumber;
     this.pushIntToken(this.subarray(start, this.pos), false, start, this.pos);
     return;
    }
   }

   endOfNumber = this.pos;
   if (this.isChar('L', 'l')) {
    if (isReal) {
     this.raiseParseException(start, "REAL_CANNOT_BE_LONG", null);
    }

    this.pushIntToken(this.subarray(start, endOfNumber), true, start, endOfNumber);
    ++this.pos;
   } else if (this.isExponentChar(this.charsToProcess[this.pos])) {
    isReal = true;
    ++this.pos;
    char possibleSign = this.charsToProcess[this.pos];
    if (this.isSign(possibleSign)) {
     ++this.pos;
    }

    do {
     ++this.pos;
    } while(this.isDigit(this.charsToProcess[this.pos]));

    boolean isFloat = false;
    if (this.isFloatSuffix(this.charsToProcess[this.pos])) {
     isFloat = true;
     endOfNumber = ++this.pos;
    } else if (this.isDoubleSuffix(this.charsToProcess[this.pos])) {
     endOfNumber = ++this.pos;
    }

    this.pushRealToken(this.subarray(start, this.pos), isFloat, start, this.pos);
   } else {
    ch = this.charsToProcess[this.pos];
    boolean isFloat = false;
    if (this.isFloatSuffix(ch)) {
     isReal = true;
     isFloat = true;
     endOfNumber = ++this.pos;
    } else if (this.isDoubleSuffix(ch)) {
     isReal = true;
     endOfNumber = ++this.pos;
    }

    if (isReal) {
     this.pushRealToken(this.subarray(start, endOfNumber), isFloat, start, endOfNumber);
    } else {
     this.pushIntToken(this.subarray(start, endOfNumber), false, start, endOfNumber);
    }
   }

  }
 }

 private void lexIdentifier() {
  int start = this.pos;

  do {
   ++this.pos;
  } while(this.isIdentifier(this.charsToProcess[this.pos]));

  char[] subarray = this.subarray(start, this.pos);
  if (this.pos - start == 2 || this.pos - start == 3) {
   String asString = (new String(subarray)).toUpperCase();
   int idx = Arrays.binarySearch(ALTERNATIVE_OPERATOR_NAMES, asString);
   if (idx >= 0) {
    this.pushOneCharOrTwoCharToken(TokenType.valueOf(asString), start, subarray);
    return;
   }
  }

  this.tokens.add(new Token(TokenType.IDENTIFIER, subarray, start, this.pos));
 }

 private void pushIntToken(char[] data, boolean isLong, int start, int end) {
  if (isLong) {
   this.tokens.add(new Token(TokenType.LITERAL_LONG, data, start, end));
  } else {
   this.tokens.add(new Token(TokenType.LITERAL_INT, data, start, end));
  }

 }

 private void pushHexIntToken(char[] data, boolean isLong, int start, int end) {
  if (data.length == 0) {
   if (isLong) {
    this.raiseParseException(start, "NOT_A_LONG", this.expression.substring(start, end + 1));
   } else {
    this.raiseParseException(start, "NOT_AN_INTEGER", this.expression.substring(start, end));
   }
  }

  if (isLong) {
   this.tokens.add(new Token(TokenType.LITERAL_HEXLONG, data, start, end));
  } else {
   this.tokens.add(new Token(TokenType.LITERAL_HEXINT, data, start, end));
  }

 }

 private void pushRealToken(char[] data, boolean isFloat, int start, int end) {
  if (isFloat) {
   this.tokens.add(new Token(TokenType.LITERAL_REAL_FLOAT, data, start, end));
  } else {
   this.tokens.add(new Token(TokenType.LITERAL_REAL, data, start, end));
  }

 }

 private char[] subarray(int start, int end) {
  return Arrays.copyOfRange(this.charsToProcess, start, end);
 }

 private boolean isTwoCharToken(TokenType kind) {
  return kind.tokenChars.length == 2 && this.charsToProcess[this.pos] == kind.tokenChars[0] && this.charsToProcess[this.pos + 1] == kind.tokenChars[1];
 }

 private void pushCharToken(TokenType kind) {
  this.tokens.add(new Token(kind, this.pos, this.pos + 1));
  ++this.pos;
 }

 private void pushPairToken(TokenType kind) {
  this.tokens.add(new Token(kind, this.pos, this.pos + 2));
  this.pos += 2;
 }

 private void pushOneCharOrTwoCharToken(TokenType kind, int pos, char[] data) {
  this.tokens.add(new Token(kind, data, pos, pos + kind.getLength()));
 }

 private boolean isIdentifier(char ch) {
  return this.isAlphabetic(ch) || this.isDigit(ch) || ch == '_' || ch == '$';
 }

 private boolean isChar(char a, char b) {
  char ch = this.charsToProcess[this.pos];
  return ch == a || ch == b;
 }

 private boolean isExponentChar(char ch) {
  return ch == 'e' || ch == 'E';
 }

 private boolean isFloatSuffix(char ch) {
  return ch == 'f' || ch == 'F';
 }

 private boolean isDoubleSuffix(char ch) {
  return ch == 'd' || ch == 'D';
 }

 private boolean isSign(char ch) {
  return ch == '+' || ch == '-';
 }

 private boolean isDigit(char ch) {
  if (ch > 255) {
   return false;
  } else {
   return (FLAGS[ch] & 1) != 0;
  }
 }

 private boolean isAlphabetic(char ch) {
  if (ch > 255) {
   return false;
  } else {
   return (FLAGS[ch] & 4) != 0;
  }
 }

 private boolean isHexadecimalDigit(char ch) {
  if (ch > 255) {
   return false;
  } else {
   return (FLAGS[ch] & 2) != 0;
  }
 }

 private boolean isExhausted() {
  return this.pos == this.max - 1;
 }

 private void raiseParseException(int start, String msg, String expression) {
  throw new ExprParserException(expression,msg,start);
 }

 static {
  byte[] var10000;
  int ch;
  for(ch = 48; ch <= 57; ++ch) {
   var10000 = FLAGS;
   var10000[ch] = (byte)(var10000[ch] | 3);
  }

  for(ch = 65; ch <= 70; ++ch) {
   var10000 = FLAGS;
   var10000[ch] = (byte)(var10000[ch] | 2);
  }

  for(ch = 97; ch <= 102; ++ch) {
   var10000 = FLAGS;
   var10000[ch] = (byte)(var10000[ch] | 2);
  }

  for(ch = 65; ch <= 90; ++ch) {
   var10000 = FLAGS;
   var10000[ch] = (byte)(var10000[ch] | 4);
  }

  for(ch = 97; ch <= 122; ++ch) {
   var10000 = FLAGS;
   var10000[ch] = (byte)(var10000[ch] | 4);
  }

 }

}
