# Main Branch
- This branch will contain the stable and production-ready code.
- Only commits that have been reviewed and approved should be merged into this branch.
# Feature Branches
- **Naming convention**: `feat/this-is-feature-name`
- These branches will be used to develop **new features or enhancements.**
- Each feature branch should be **based on the main branch**.
- Only the developer working on the feature should merge the feature branch into the develop branch after completing the development and passing code review.
# Adding Features In 6 Steps
Under no circumstances should you push to the main branch. Instead, follow these steps:
1. Create a new feature branch from the main branch.
2. Implement the feature or enhancement in the feature branch.
3. Write tests to cover the new feature or changes.
4. **Push your branch after rebasing the main branch:**
	- You must make sure that your PR will not result in merge conflicts.
	- If there are conflicts, you need to resolve them locally.
5. **Create a pull request:** 
	- Write descriptive title.
	- Write changelog and reasons behind them.
	- Assign yourself for the task and assign reviewers.
	- Use **labels** to categorize PR and **milestones** to track progress.
6. **After approval:**
	1. Squash commits if needed, to remove redundant changes and make history easier to read ([Squash step-by-step](https://github.com/Ahmad-AlDeeb/demo-db-to-kafka-to-db/blob/main/docs/Squash%20Steps.md)).
	2. Merge the feature branch into the main branch.
	3. Delete remote branch.
# Commit Messages
- Use a clear, descriptive and concise but informative commit message.
- Message should explains the **PURPOSE** of the change.
- Start the commit message with a **capital letter** and use the imperative mood (e.g., “Add feature” instead of “Added feature”).
- Reference relevant issues or tasks in the commit message using keywords like “Fixes,” “Closes,” or “Resolves” followed by the issue number (e.g., “Fixes #123”).
- Please avoid typos.
# 🔴 FAQ
- What if the new task is dependent on open pull request?
	1. Work on that branch you need but without committing.
	2. If any changes were requested from reviewers on that PR:
		- **If it's your PR:** stash, modify & push, then apply stash.
		- **If it's NOT your PR:** when the changes are pushed, stash, pull, then apply stash.
	3. When PR is FINALLY merged:
		1. Stash the new task changes.
		2. Checkout to main and pull.
		3. Create a new branch for the new task and apply stash.
