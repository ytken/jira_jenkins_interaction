pipeline {
    stages {
        stage('env-var') {
            steps {
                script {
                    env.pathToDir = ""
                    env.scriptToSurroundShellCommands  = """#!/bin/bash
                                        shopt -s expand_aliases
                                        source /etc/profile
                                        source /etc/bashrc
                                        source ~/.bashrc
                                        source /fs/GE/default/common/jenkins_settings.sh"""
                }
            }
        }
        stage('work') {
            steps {
                script {
                    env.pathToDir = sh(returnStdout: true, script: "pwd").trim()
                    sh "python ${env.pathToDir}/run.py \"Test Jira_python\" \"Description Test Jira_python\""
                }
            }
        }
    }
}