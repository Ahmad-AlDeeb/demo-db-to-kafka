# Squashing
1. **Start Interactive Rebase**: `git rebase -i HEAD~n` where n = number of commits.
2. Change `pick` to `squash` or `s` for the commits you want to squash.
3. A new editor will be opened to write a new message for the squashed commits.
4. Resolve any conflicts if they arise and continue the rebase: `git rebase --continue`.
5. Force push changes.
