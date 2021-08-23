package ar.com.miura.expert.graph

class AncestralTree(name: Char) {
    val name = name
    var ancestor: AncestralTree? = null
}

class TreeSolution {
    fun getYoungestCommonAncestor(
        topAncestor: AncestralTree,
        descendantOne: AncestralTree,
        descendantTwo: AncestralTree
    ): AncestralTree? {
        // Write your code here.
        var oneLevel = getLevel(topAncestor, descendantOne)
        var secondLevel = getLevel(topAncestor, descendantTwo)

        var firstNode = AncestralTree('*')
        var secondNode = AncestralTree('*')

        if (oneLevel > secondLevel) {
            return commonAncestor(descendantOne, descendantTwo, oneLevel, secondLevel)
        } else {
            return commonAncestor(descendantTwo, descendantOne, secondLevel, oneLevel)
        }
    }

    private fun commonAncestor(
        descendantOne: AncestralTree,
        descendantTwo: AncestralTree,
        oneLevel: Int,
        secondLevel: Int
    ): AncestralTree? {

        var firstNode: AncestralTree? = descendantOne;
        var secondNode: AncestralTree? = descendantTwo

        var oneCounter = oneLevel
        var secondCounter = secondLevel
        while (oneCounter > secondCounter) {
            oneCounter--
            firstNode = firstNode!!.ancestor
        }

        while (firstNode != secondNode) {
            if (firstNode != null) {
                firstNode = firstNode.ancestor
            }
            if (secondNode != null) {
                secondNode = secondNode.ancestor
            }
        }
        return firstNode
    }

    private fun getLevel(topAncestor: AncestralTree?, descendantOne: AncestralTree?): Int {
        var level = 0
        var tempDescendant = descendantOne
        while (tempDescendant != topAncestor) {
            level++
            tempDescendant = tempDescendant!!.ancestor
        }
        return level
    }

}

