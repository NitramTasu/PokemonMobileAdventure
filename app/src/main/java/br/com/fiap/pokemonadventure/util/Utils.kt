package br.com.fiap.pokemonadventure.util

class Utils{
    companion object {
        fun getStringWithoutSpecialChars(word: String): String {
            var _word = word
            _word = _word.replace('(', ' ')
            _word = _word.replace(')', ' ')
            _word = _word.replace('-', ' ')
            _word = _word.replace('.', ' ')
            _word = _word.replace(" ", "")

            return _word
        }
    }
}