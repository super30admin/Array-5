//
//  RobotRoundedInCircle.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/24/26.
//

class RobotRoundedInCircle {
    
    //time complexity - O(4l)
    func isRobotBounded(_ instructions: String) -> Bool {
        let instruArr = Array(instructions)
        let dirs = [[0,1], [1,0], [0, -1], [-1, 0]]
        var idx = 0 //initial direction - xIdx
        var x = 0
        var y = 0
        for k in 0..<4 {
            for i in 0..<instruArr.count {
                let ch = instruArr[i]
                if (ch == "L") {
                    idx = (idx + 1) % 4
                } else if (ch == "R") {
                    idx = (idx + 3) % 4
                } else {
                    x += dirs[idx][0]
                    y += dirs[idx][1]
                }
            }
            if (x == 0 && y == 0) {
                return true
            }
        }
        return false
    }
    
    //alternative
    /*
     When we don't repeat the statements 4 no of times. We repeat it only once.
     After repeating the instructions - if robot is at the origin then return true
     after repeating 1 set of instructions, if the robot is not at the origin and not facing north then it will surely come back to the origin. Either by repeating once or 4 times.
     */
    
        //O(l) - length of instruction
        func isRobotBoundedOptimal(_ instructions: String) -> Bool {
            let instruArr = Array(instructions)
            let dirs = [[0,1], [1,0], [0, -1], [-1, 0]]
            var idx = 0 //initial direction - xIdx
            var x = 0
            var y = 0
            for i in 0..<instruArr.count {
                let ch = instruArr[i]
                if (ch == "L") {
                    idx = (idx + 1) % 4
                } else if (ch == "R") {
                    idx = (idx + 3) % 4
                } else {
                    x += dirs[idx][0]
                    y += dirs[idx][1]
                }
            }
            if (x == 0 && y == 0 || idx != 0) {
                return true
            }
            return false
        }
}
