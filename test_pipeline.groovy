pipeline {
    agent { docker { image 'python:3.10.7-alpine' } }
    stages {
        stage('env-var') {
            steps {
                script {
                    env.pathToDir = "/home/aovchinnikova/apps/git/jira_jenkins_interaction"
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
                    sh "python ${env.pathToDir}/run.py \"Test Jira_python\" \"Description Test Jira_python\""
                }
            }
        }
    }
}