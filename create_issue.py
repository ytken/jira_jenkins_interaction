import sys
from jira import JIRA

def create_custom_issue(jira_auth, summary, description, assignee_name,
                proj_key="DEVOPS", 
                issue_type="Bug",
                reporter_name="a.ovchinnikova",
                priority="Medium",
                labels=[],
                epic_link="Regress"
                ):
    issue_fields = {
        "project"     : {"key": proj_key},
        "issuetype"   : {"name": issue_type},   # Bug Task Story Epic
        "summary"     : summary,
        "reporter"    : {"name":reporter_name},
        "description" : description,
        "priority"    : {"name": priority}, # Highest High Medium Low Lowest Blocker
        "labels"      : labels,
        "assignee"    : {"name": assignee_name},
        "customfield_10108"   : "DEVOPS-3"
    }

    jira_auth.create_issue(issue_fields)

jira_options = {'server': 'https://j-ymp.yadro.com'}
jira = JIRA(options=jira_options, basic_auth=("a.ovchinnikova", "IreN951a"))

create_custom_issue(jira, *sys.argv[1:])