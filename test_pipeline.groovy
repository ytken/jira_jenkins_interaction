pipeline {
    agent any
    stages {
        stage('env-var') {
            steps {
                script {
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
                    sh "python3 run.py \"Test Jira_python\" \"Description Test Jira_python\""
                }
            }
        }
    }
}